package google.example.test;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import google.example.GoogleSearch;
import org.testng.annotations.BeforeClass;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class BaseTest {

    @BeforeClass
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1240x1200";
        Configuration.baseUrl = "https://www.google.co/";
//        com.codeborne.selenide.logevents.SelenideLogger.addListener("AllureSelenide",
//                new AllureSelenide()
//                        .screenshots(true)
//                        .savePageSource(false)// Включить скриншоты для каждого действия
//        );
    }

    static String dateStr = "07-11-2006";

    public String getCurrentUrl() {
        return WebDriverRunner.getWebDriver().getCurrentUrl();
    }

    public GoogleSearch openBaseUrl() {
        Selenide.open(Configuration.baseUrl);
        return new GoogleSearch();
    }

    public static LocalDate parseDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            return LocalDate.parse(birthDate, formatter);
        } catch (DateTimeParseException ignored) {
        }
        return null;
    }

    public static int calculateAge(LocalDate birthDay) {
        LocalDate birthDay1 = parseDate(dateStr);
        LocalDate currentDate = LocalDate.now();
        if (birthDay1 != null && birthDay.isBefore(currentDate)) {
            return Period.between(birthDay, currentDate).getYears();
        } else {
            throw new IllegalArgumentException("The date cannot be less than current date");
        }
    }

    public static void main(String[] args) {

        LocalDate birthDay = parseDate(dateStr);
        if (birthDay != null) {
            try {
                int age = calculateAge(birthDay);
                System.out.println(age);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else {
            System.out.println("Invalid date format: " + dateStr);
            System.out.println("Please enter your date of birth in the following format: dd-MM-yyyy");
        }
    }
}


