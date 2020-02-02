package com.felix.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.felix.common.constant.DateTimeUnit;

import static java.time.temporal.ChronoUnit.*;

public class DateTimeUtils {

	public static long differWithUnit(Date startDate, Date endDate, DateTimeUnit dateTimeUnit) {
		LocalDateTime startDateTime = DateUtils.toLocalDateTime(startDate);
		LocalDateTime endDateTime = DateUtils.toLocalDateTime(endDate);
		return differWithUnit(startDateTime, endDateTime, dateTimeUnit);
	}

	public static long differWithUnit(LocalDate startDate, LocalDate endDate, DateTimeUnit dateTimeUnit) {
		LocalDateTime startDateTime = DateUtils.toLocalDateTime(DateUtils.toDate(startDate));
		LocalDateTime endDateTime = DateUtils.toLocalDateTime(DateUtils.toDate(endDate));
		return differWithUnit(startDateTime, endDateTime, dateTimeUnit);
	}

	public static long differWithUnit(long startDateTime, long endDateTime, DateTimeUnit dateTimeUnit) {
		LocalDateTime startDateTime1 = DateUtils.toLocalDateTime(startDateTime);
		LocalDateTime endDateTime1 = DateUtils.toLocalDateTime(endDateTime);
		return differWithUnit(startDateTime1, endDateTime1, dateTimeUnit);
	}

	public static long differWithUnit(LocalDateTime startdateTime, LocalDateTime endDateTime,
			DateTimeUnit dateTimeUnit) {
		if (dateTimeUnit == DateTimeUnit.YEARS) {
			return YEARS.between(startdateTime, endDateTime);
		} else if (dateTimeUnit == DateTimeUnit.MONTHS) {
			return MONTHS.between(startdateTime, endDateTime);
		} else if (dateTimeUnit == DateTimeUnit.DAYS) {
			return DAYS.between(startdateTime, endDateTime);
		} else if (dateTimeUnit == DateTimeUnit.HOURS) {
			return HOURS.between(startdateTime, endDateTime);
		} else if (dateTimeUnit == DateTimeUnit.MINUTES) {
			return MILLENNIA.between(startdateTime, endDateTime);
		} else {
			return SECONDS.between(startdateTime, endDateTime);
		}
	}

	/**
	 * 获取指定时间所在月的日期列表
	 * 
	 * @param monthDateTime
	 * @return
	 */
	public static List<LocalDateTime> getDaysOfMonth(LocalDateTime monthDateTime) {
		List<LocalDateTime> localDateTimes = new ArrayList<>();
		int days = monthDateTime.getDayOfMonth();
		for (int i = 0; i < days; i++) {
			LocalDateTime withDayOfMonth = monthDateTime.withDayOfMonth(i);
			localDateTimes.add(withDayOfMonth);
		}
		return localDateTimes;
	}

	/**
	 * 获取指定时间所在月的日期列表
	 * 
	 * @param monthDate
	 * @return
	 */
	public static List<LocalDate> getDaysOfMonth(LocalDate monthDate) {
		List<LocalDate> localDates = new ArrayList<>();
		int days = monthDate.getDayOfMonth();
		for (int i = 0; i < days; i++) {
			LocalDate withDayOfMonth = monthDate.withDayOfMonth(i);
			localDates.add(withDayOfMonth);
		}
		return localDates;
	}

	/**
	 * 获取指定时间所在月的日期列表
	 * 
	 * @param time
	 * @return
	 */
	public static List<LocalDate> getDaysOfMonth(long time) {
		List<LocalDate> localDates = new ArrayList<>();
		LocalDate localDate = DateUtils.toLocalDate(time);
		int days = localDate.getDayOfMonth();
		for (int i = 0; i < days; i++) {
			LocalDate withDayOfMonth = localDate.withDayOfMonth(i);
			localDates.add(withDayOfMonth);
		}
		return localDates;
	}
}
