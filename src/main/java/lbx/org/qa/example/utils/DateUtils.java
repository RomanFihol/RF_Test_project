package lbx.org.qa.example.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    //  Getting date 20 years ago
    public static String getDate20YearsAgo() {
        return LocalDate.now().minusYears(20).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    //  Getting some future date
    public static String getFutureDate() {
        return LocalDate.now().plusYears(20).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    //  Getting 18 years old
    public static String getAgeEqual18() {
        return LocalDate.now().minusYears(18).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    //  Getting 1 day younger than 18 years old
    public static String getAgeLessThan18() {
        return LocalDate.now().minusYears(18).plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    //  Getting 1 day older than 18 years old
    public static String getAgeMoreThan18() {
        return LocalDate.now().minusYears(18).minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    // The method for calculating age
    public int calculateAge(String birthDateStr) {
        LocalDate currentDate = LocalDate.now();
        return Period.between(LocalDate.parse(birthDateStr), currentDate).getYears();
    }
}
