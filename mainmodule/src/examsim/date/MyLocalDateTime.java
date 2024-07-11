package src.examsim.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLocalDateTime {
    public MyLocalDateTime() {
        return;
    }

    public static void main(String[] args) {
        datePattern();
        System.out.println();
        dateTimePattern();
    }

    private static void datePattern() {
        LocalDate date = LocalDate.now();
        System.out.println("date: " + date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd");
        String format = date.format(formatter);
        System.out.println("Format: " + format);
        LocalDate parse = LocalDate.parse(format, formatter);
        System.out.println("parse: " + parse);
    }

    private static void dateTimePattern() {
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("date: " + dateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMMM dd',' h:mma B");
        String format = dateTime.format(formatter);
        System.out.println("Format: " + format);
        LocalDate parse = LocalDate.parse(format, formatter);
        System.out.println("parse: " + parse);
    }
}
