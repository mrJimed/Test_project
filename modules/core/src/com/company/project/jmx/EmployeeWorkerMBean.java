package com.company.project.jmx;

import org.springframework.jmx.export.annotation.ManagedResource;
import com.haulmont.cuba.core.sys.jmx.JmxBean;

@JmxBean(module = "project", alias = "employeeWorker")
@ManagedResource(description = "JMX bean for some settings")
public interface EmployeeWorkerMBean {
    void sendGreetings();
}