package com.lisovitskiy.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateService {
	public static java.sql.Date toSqlDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		java.sql.Date sqlDate = java.sql.Date.valueOf(LocalDate.parse(date, formatter));
		return sqlDate;
	}
}
