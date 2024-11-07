package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import exceptions.InvalidDateFormatException;
import exceptions.FutureDateException;

public class DateUtils {
    public static LocalDate parseDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            return LocalDate.parse(birthDate, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormatException("Invalid date format. Please use dd-MM-yyyy.");
        }
    }

    // The method for calculating age
    public static int calculateAge(String birthDateStr) {
        LocalDate birthDay = parseDate(birthDateStr);
        LocalDate currentDate = LocalDate.now();

        // Check if the date of birth is not greater than now
        if (birthDay.isAfter(currentDate)) {
            throw new FutureDateException("The birth date cannot be in the future.");
        }
        return Period.between(birthDay, currentDate).getYears();
    }
}
