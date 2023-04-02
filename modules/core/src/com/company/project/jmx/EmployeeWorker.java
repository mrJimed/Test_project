package com.company.project.jmx;

import com.company.project.entity.Employee;
import com.haulmont.cuba.core.*;
import com.haulmont.cuba.core.app.EmailSenderAPI;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.app.Emailer;
import com.haulmont.cuba.core.app.EmailerAPI;
import com.haulmont.cuba.core.global.EmailException;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.EmailInfoBuilder;
import com.haulmont.cuba.core.global.Scripting;
import groovy.lang.Binding;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.validation.constraints.Email;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component("project_EmployeeWorker")
public class EmployeeWorker implements EmployeeWorkerMBean {
    @Inject
    protected Persistence persistence;

    @Inject
    protected EmailerAPI emailerAPI;
    @Inject
    protected Scripting scripting;

    @Inject
    protected Logger logger;

    private String getEmailText(String firstName, String lastName, String companyName, Date birthday) {
        Integer age = new Date().getYear() - birthday.getYear();
        Binding binding = new Binding();

        binding.setVariable("firstName", firstName);
        binding.setVariable("lastName", lastName);
        binding.setVariable("age", age);
        binding.setVariable("companyName", companyName);
        return scripting.runGroovyScript("com/company/project/GetEmailText.groovy", binding);
    }

    private void sendByEmail(String emailAddress, String emailText) {
        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses(emailAddress)
                .setCaption("Поздравление!")
                .setFrom(null)
                .setTemplatePath("com/company/project/email.txt")
                .setTemplateParameters(Collections.singletonMap("emailText", emailText))
                .build();
        emailerAPI.sendEmailAsync(emailInfo);
    }

    @Override
    public void sendGreetings() {
        String sql = "select e " +
                "from project_Employee e " +
                "where extract(day from e.birthday) = extract(day from current_date) and " +
                "extract(month from e.birthday) = extract(month from current_date)";

        try (Transaction transaction = persistence.createTransaction()) {
            EntityManager entityManager = persistence.getEntityManager();
            TypedQuery<Employee> query = entityManager.createQuery(sql, Employee.class);

            for (Employee employee : query.getResultList()) {
                String emailText = getEmailText(employee.getFirstName(), employee.getLastName(),
                        employee.getCarService().getName(), employee.getBirthday());
                sendByEmail(employee.getEmail(), emailText);
            }
            transaction.commit();
        }
    }
}