package com.segema.datetime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateTimeDemo01 {

	public static void main(String[] args) {
		// 创建时间对象
		LocalDateTime timePoint = LocalDateTime.now(); // 当前时间
		System.out.println("--当前时间----");
		System.out.println(timePoint);
		System.out.println("");

		System.out.println("--自定义时间----");
		System.out.println(LocalDate.of(2012, Month.DECEMBER, 12)); // from
		// values
		System.out.println(LocalDate.ofEpochDay(150)); // middle of 1970
		System.out.println(LocalTime.of(17, 18)); // the train I took home today
		System.out.println(LocalTime.parse("10:15:30")); // From a String
		System.out.println("");

		System.out.println("--获取时间的各个部分----");
		System.out.println(timePoint.toLocalDate());
		System.out.println(timePoint.getMonth());
		System.out.println(timePoint.getDayOfMonth());
		System.out.println(timePoint.getSecond());
		System.out.println("");

		System.out.println("---设置并返回新的时间对象---");
		LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);
		System.out.println(thePast);
		System.out.println("---再加3周---");
		LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3, ChronoUnit.WEEKS);
		System.out.println(yetAnother);
		System.out.println("");

		System.out.println("---使用时间调整函数---");
		System.out.println(timePoint);
		//System.out.println(timePoint.with(lastDayOfMonth()));
		//System.out.println(timePoint.with(previousOrSame(DayOfWeek.WEDNESDAY)));
		System.out.println(timePoint.with(LocalTime.now()));
		System.out.println("");

		System.out.println("---截断时间精确位--");
		System.out.println(timePoint);
		LocalDateTime truncatedTimeToMinutes = timePoint.truncatedTo(ChronoUnit.MINUTES);
		System.out.println(truncatedTimeToMinutes);
		LocalDateTime truncatedTimeToSeconds = timePoint.truncatedTo(ChronoUnit.SECONDS);
		System.out.println(truncatedTimeToSeconds);
		System.out.println("");

		System.out.println("---使用时区---");
		ZonedDateTime zoned_now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+08:00"));
		System.out.println(zoned_now.withZoneSameInstant(ZoneId.of("UTC+00:00")));
		System.out.println(zoned_now.getOffset());
		System.out.println("");

		System.out.println("---时间上使用时区偏移---");
		OffsetTime time = OffsetTime.now();
		ZoneOffset offset = ZoneOffset.of("+02:00");
		System.out.println(time);
		System.out.println(time.withOffsetSameInstant(offset));
		System.out.println("");

		System.out.println("---时间加减---");
		timePoint = LocalDateTime.now();
		System.out.println(timePoint);
		// 3 years, 2 months, 1 day
		Period period1 = Period.of(3, 2, 1);
		System.out.println(timePoint.plus(period1));
		Duration duration = Duration.ofSeconds(3, 5);
		System.out.println(timePoint.plus(duration));
		Duration sixHours = Duration.between(ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+08:00")),
				ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+02:00")));
		System.out.println(timePoint.plus(sixHours));
		System.out.println("");

	}

}
