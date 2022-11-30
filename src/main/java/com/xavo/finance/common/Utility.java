package com.xavo.finance.common;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Utility {
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static java.sql.Date parseDate(String date) {
		try {
			return new Date(DATE_FORMAT.parse(date).getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
