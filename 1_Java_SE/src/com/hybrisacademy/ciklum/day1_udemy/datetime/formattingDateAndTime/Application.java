package com.hybrisacademy.ciklum.day1_udemy.datetime.formattingDateAndTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.Date;

import org.apache.logging.log4j.Logger;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("DateTimeLecture4_formatting");


    
	public static void main(String[] args) {
	    LocalDate date = LocalDate.of(2030, Month.JANUARY, 1);
	    LocalTime time = LocalTime.of(11,22,33);
	    LocalDateTime localDateTime = LocalDateTime.of(date, time);
	    
	    logger.info("example1 - ISO_LOCAL");
        logger.trace(localDateTime);
        logger.trace(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE));
        logger.trace(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        logger.trace(localDateTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        
		logger.info("\nexample2 - ofLocalized");
		DateTimeFormatter shortFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter mediumFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        
        logger.trace(shortFormatter.format(localDateTime));
        logger.trace(localDateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
        logger.trace(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).format(localDateTime));
        logger.trace(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(localDateTime));

        logger.trace(mediumFormatter.format(date));
        logger.trace(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(time));

		logger.info("\nexample3 - ofPattern");
		logger.trace(DateTimeFormatter.ofPattern("M d, y, hh:mm").format(localDateTime));
		logger.trace(DateTimeFormatter.ofPattern("MM dd, yy, hh:mm").format(localDateTime));
		logger.trace(DateTimeFormatter.ofPattern("MMM dd, yyy , hh:mm").format(localDateTime));
		logger.trace(DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm").format(localDateTime));

		logger.info("\nexample4 - before Java8");
		SimpleDateFormat sf = new SimpleDateFormat("hh:mm");
		logger.trace(sf.format(new Date()));

		logger.info("\nexample5 - timeFormatter + date = Exception");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm");
        logger.trace(dtf.format(localDateTime));
        try {
        	logger.trace(dtf.format(date));
		} catch (UnsupportedTemporalTypeException e) {
			logger.trace(e);
		}
        logger.trace(dtf.format(time));	}
	
	
}
