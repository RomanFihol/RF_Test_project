package lbx.org.qa.example.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import io.qameta.allure.Attachment;
import lbx.org.qa.example.exceptions.InvalidDateFormatException;
import lbx.org.qa.example.exceptions.UnderAgeException;

public class DateUtils {

    @Attachment(value = "Error Message", type = "text/plain")
    private String addAllureErrorMessage(String message) {
        return message;
    }

    public LocalDate parseDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            return LocalDate.parse(birthDate, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException("Invalid date format. Please use dd-MM-yyyy.", e);
        }
    }

    // The method for calculating age
    public int calculateAge(String birthDateStr) {
        LocalDate birthDay = parseDate(birthDateStr);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDay, currentDate).getYears();
    }

    // Method for verifying the age
    public Boolean checkAge(int age) {
        if (age < 0) {
            addAllureErrorMessage("Your age is:" + age);
            throw new IllegalArgumentException("Birthday can not be negative");
        } else if (age >= 0 && age < 18) {
            addAllureErrorMessage("Your age is:" + age);
            throw new UnderAgeException("Your age is less then 18");
        } else {
            return true;
        }
    }
}
