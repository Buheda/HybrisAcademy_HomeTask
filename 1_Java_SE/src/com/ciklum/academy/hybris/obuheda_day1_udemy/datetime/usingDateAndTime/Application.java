package com.ciklum.academy.hybris.obuheda_day1_udemy.datetime.usingDateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.Logger;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("DateTimeLecture2_using");

	public static void main(String[] args) {
		example1();
		example2();
		example3();
	}
	
	static void example1() {
		logger.info("example1 - localDateTime plus minus");
        LocalDate date = LocalDate.of(2030, Month.JANUARY, 10);
        logger.trace(date);
        date = date.plusDays(5).plusMonths(2);
        logger.trace(date);
        
        LocalTime time = LocalTime.of(10,30);
        logger.trace(time);
        time = time.plusHours(2).plusMinutes(20);
        logger.trace(time);
        
        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        logger.trace(localDateTime);
        localDateTime = localDateTime.minusHours(10).plusDays(2).plusWeeks(1);
        logger.trace(localDateTime);
	}
	
	static void example2() {
		logger.info("\nexample2 - calendar before java8");

		Date myDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.MONTH, 2);
        myDate = calendar.getTime();
        logger.trace(myDate);
	}
	
	static void example3() {
		logger.info("\nexample3 - localDate is immutable");
        LocalDate ld = LocalDate.of(2010, Month.APRIL, 1);
        logger.trace(ld);
        ld.plusDays(10);
        logger.trace(ld);
	}
}
