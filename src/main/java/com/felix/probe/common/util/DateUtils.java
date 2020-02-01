package com.felix.probe.common.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtils {

	/**
	 * 将 LocalDate 转为 Date
	 * 
	 * @param localDate
	 * @return
	 */
	public static Date toDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 将 LocalDateTime 转为 Date
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 将 long 转为 Date
	 * 
	 * @param time
	 * @return
	 */
	public static Date toDate(long time) {
		return toDate(toLocalDate(time));
	}

	/**
	 * 将 Date 转为 LocalDate
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate toLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * 将 LocalDateTime 转为 LocalDate
	 * 
	 * @param dateTime
	 * @return
	 */
	public static LocalDate toLocalDate(LocalDateTime dateTime) {
		return dateTime.toLocalDate();
	}

	/**
	 * 将 Date 转为 LocalDateTime
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * 将 long 转为 LocalDate
	 * 
	 * @param time
	 * @return
	 */
	public static LocalDate toLocalDate(long time) {
		return Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	/**
	 * 将 long 转为 LocalDateTime
	 * 
	 * @param time
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(long time) {
		return Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	/**
	 * 将 LocalDate 转为 LocalDateTime
	 * 
	 * @param localDate
	 * @return
	 */
	public static LocalDateTime toLocalDateTime(LocalDate localDate) {
		return toLocalDateTime(toDate(localDate));
	}
}
