package java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

    @Test
    public void testFormat() {
        LocalDate now = LocalDate.now();

        System.out.println(now.plusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(now.plusDays(1).format(DateTimeFormatter.ISO_DATE));
        System.out.println(now.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        LocalTime time = LocalTime.now();

        System.out.println(time.plusHours(1).format(DateTimeFormatter.ISO_TIME));
        System.out.println(time.minusMinutes(10).format(DateTimeFormatter.ofPattern("hh:mm:ss")));

    }

    @Test
    public void testCompare() {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.parse("2019-01-26", DateTimeFormatter.ISO_DATE);
        System.out.println(now.isAfter(date));


        LocalTime nowTime = LocalTime.now();
        LocalTime time = LocalTime.parse("09:45:20");
        System.out.println(nowTime.isAfter(time));
    }

    @Test
    public void testConvert() {
        // 时区ZoneId
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        // localDate转ZonedDateTime
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        // ZonedDateTime转Date
        Date date = Date.from(zdt.toInstant());

        System.out.println(date);


        Date nowDate = new Date();
        // Instant:用long表示从1970-1-1 00:00:00到现在的nanosecond
        Instant instant = nowDate.toInstant();

        LocalDate nowLocalDate = instant.atZone(zoneId).toLocalDate();
        System.out.println(nowLocalDate.format(DateTimeFormatter.ISO_DATE));
    }
}
