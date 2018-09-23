package ru.javawebinar.basejava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainDate {


    public static void main(String[] args) {
        Date date = new Date();

       // System.out.println(date);
     //   Thread.sleep(1000);
        System.out.println(date.getTime() - System.currentTimeMillis());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT-8"));
        System.out.println(calendar.getTime());

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YY");
        System.out.println( simpleDateFormat.format(date));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.YY");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(dateTimeFormatter.format(localDateTime) + " time " + dateTimeFormatter2.format(localDateTime));
    }
}
