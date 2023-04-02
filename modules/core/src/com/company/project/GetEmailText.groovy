package com.company.project

def getEmail(String firstName, String lastName, Integer age, String companyName) {
    return "Поздравляем вас с днем рождения, уважаемый ${firstName} ${lastName}!\n" +
            "Желаем всего наилучшего в ваши ${age} лет!\n" +
            "С уважением, коллектив автосервиса \"${companyName}\".";
}

return getEmail(firstName, lastName, age, companyName).toString();