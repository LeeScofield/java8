package com.demo.jdk8;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Lee on 2019-07-23.
 *
 * @author Lee
 */
public class Test14Time {

    public static void main(String[] args) {

        //当前年月日
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println(localDate.getYear()+","+localDate.getMonthValue()+","+localDate.getDayOfMonth());

        //当前时间加3天
        LocalDate plusDate = localDate.plus(3, ChronoUnit.DAYS);

        System.out.println(plusDate);

        LocalDate localDate1 = LocalDate.of(2019, 7, 24);
        System.out.println(localDate1);

        System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfMonth()));

        System.out.println("--------------------");

        //时分秒，加3小时，减5分钟
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalTime localTime1 = localTime.plusHours(3).minusMinutes(5);
        System.out.println(localTime1);


        System.out.println("--------------------");
        //只包含月和年
        YearMonth yearMonth = YearMonth.of(2019, 7);
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfYear());
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.isLeapYear()); //是否是闰年
        System.out.println("--------------------");

        //日期带时分秒
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println("--------------------");
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        System.out.println("--------------------");

        //时区
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

        TreeSet<String> strings = new TreeSet<String>() {
            {
                addAll(availableZoneIds);
            }
        };

        strings.stream().forEach(System.out::println);

        ZoneId zoneId = ZoneId.of("Asia/Chongqing");
        LocalDateTime localDateTime1 = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime1, zoneId);
        System.out.println("本地时间：" + localDateTime1 + "  重庆时间：" + zonedDateTime);

        System.out.println("--------------------");
        //Instant表示时间线上某一个点的时间，用UTC表示方式，当前时间为北京时间，东8区，在当前时间减去8小时，就是格林威治时间
        Instant now = Instant.now();
        System.out.println(localDateTime);
        System.out.println(now);

        System.out.println("--------------------");
        LocalDate date1 = LocalDate.of(2016, 9, 25);
        LocalDate date2 = LocalDate.of(2019, 7, 29);

        //二个日期时间差，包含前面日期，不包含后面日期
        Period period = Period.between(date1, date2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());



    }

}
