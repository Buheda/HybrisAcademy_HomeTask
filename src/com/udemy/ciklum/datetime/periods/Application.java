package com.udemy.ciklum.datetime.periods;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("DateTimeLecture3_periods");

	public static void main(String[] args) {
		LocalDate start = LocalDate.of(2121, Month.JANUARY, 1);
		LocalDate end = LocalDate.of(2121, Month.APRIL, 30);
	
		logger.info("example1 - start, end");
		cleanAnimalCage(start, end);
		
		logger.info("\nexample2 - start, end, period");
		Period period = Period.ofWeeks(1);
		cleanAnimalCage(start, end, period);
		
		logger.info("\nexample3 - LocalTime+period = exception");	
		logger.trace(start.plus(period));
		logger.trace(LocalDateTime.now());
		logger.trace(LocalDateTime.now().plus(period));
		try {
			logger.trace(LocalTime.now().plus(period));
		} catch (UnsupportedTemporalTypeException e) {
			logger.trace(e);
		}

		logger.info("\nexample4 - Period.of is static");
		Period yearAndMonth = Period.ofYears(1);
		logger.trace(yearAndMonth);
		yearAndMonth = Period.ofYears(1).ofMonths(1);
		logger.trace(yearAndMonth);
		yearAndMonth = Period.of(1,1,0);
		logger.trace(yearAndMonth);
	}
	
    public static void cleanAnimalCage(LocalDate start, LocalDate end) {
		while (start.isBefore(end)) {
			logger.trace("Need to clean the cage on date= " + start);
		    start = start.plusMonths(1);
		}
    }
	
	public static void cleanAnimalCage(LocalDate start, LocalDate end, Period period) {
	   while (start.isBefore(end)) {
		   logger.trace("Need to clean the cage on date= " + start);
           start = start.plus(period);
        }
	}
}
