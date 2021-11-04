package com.ciklum.academy.hybris.obuheda_day1_udemy.datetime.creatingDateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.Logger;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("DateTimeLecture1_creating");

	public static void main(String[] args) {
		logger.info("example1 - now");
		logger.trace(LocalDate.now());
        logger.trace(LocalTime.now());
        logger.trace(LocalDateTime.now());
        
        logger.info("\nexample2 - LocalDateTime.of");
		LocalDate localDate = LocalDate.of(2122, Month.OCTOBER, 31);
	    LocalTime localTime = LocalTime.of(10,30);
        logger.trace(localDate);
        logger.trace(localTime);
        logger.trace(LocalDateTime.of(localDate, localTime));
        
		logger.info("\nexample3 - calendar before Java8");
		logger.trace(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2122, Calendar.JANUARY, 1);
        Date january = calendar.getTime();
        logger.trace(january);
	}
	
}
