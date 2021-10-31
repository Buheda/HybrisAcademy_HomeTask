package com.udemy.ciklum.datetime.parsingDateTime;

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

import com.udemy.ciklum.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("DateTimeLecture5_parsing");
    
	public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("02 15 2121", formatter);
        LocalTime time = LocalTime.parse("11:33");
        
	    logger.info("example1 - parse");
        logger.trace(date);
        logger.trace(time);
        
	    logger.info("\nexample2 - formatter");
        String text = date.format(formatter);
        logger.trace(text);
        
	    logger.info("\nexample3 - parse back");
        logger.trace(LocalDate.parse(text, formatter));
        
	    logger.info("\nexample4 - update date in string, immutable localdate");
        LocalDate myDate = LocalDate.of(2010, Month.MAY, 5);
      //  String dateString = formatter.format(myDate);
        String dateString = myDate.format(formatter);
        logger.trace(dateString);

        LocalDate anotherDate = LocalDate.parse(dateString, formatter);
        anotherDate = anotherDate.plusMonths(5).plusDays(5);
        logger.trace(formatter.format(anotherDate));
        /*
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
        logger.trace(dtf.format(time));*/
	}	
}
