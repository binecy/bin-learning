package java8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTest {

    @Test
    public void testFormat() {
        // 当前时间
        LocalDate now = LocalDate.now();
        // 当前时间加一天， 并按常用格式yyyy-MM-dd格式化
        System.out.println(now.plusDays(1).format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(now.plusDays(1).format(DateTimeFormatter.ISO_DATE));
        // 当前时间减一天, 并按指定格式格式化
        System.out.println(now.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        LocalTime time = LocalTime.now();

        System.out.println(time.plusHours(1).format(DateTimeFormatter.ISO_TIME));
        System.out.println(time.minusMinutes(10).format(DateTimeFormatter.ofPattern("hh:mm:ss")));

    }

    @Test
    public void testCompare() {
        LocalDate now = LocalDate.now();
        // 字符串转时间
        LocalDate date = LocalDate.parse("2019-01-26", DateTimeFormatter.ISO_DATE);
        // 时间比较
        System.out.println(now.isAfter(date));


        LocalTime nowTime = LocalTime.now();
        LocalTime time = LocalTime.parse("09:45:20");
        System.out.println(nowTime.isAfter(time));
    }

    @Test
    public void testConvert() {
        // 时区ZoneId LocalDate时区不相关, Date时区, 两者转化需使用ZoneId
        ZoneId zoneId = ZoneId.systemDefault();


        LocalDate localDate = LocalDate.now();
        // localDate转ZonedDateTime
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        // ZonedDateTime转Date
        Date date = Date.from(zdt.toInstant());

        System.out.println(date);


        Date nowDate = new Date();
        // Instant:nanosecond表示的时间戳
        Instant instant = nowDate.toInstant();
        // instant转ZonedDateTime
        ZonedDateTime nowZonedDate = instant.atZone(zoneId);
        // ZonedDateTime转LocalDate
        LocalDate nowLocalDate = nowZonedDate.toLocalDate();
        System.out.println(nowLocalDate.format(DateTimeFormatter.ISO_DATE));
    }
}
