package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerUtil {
	private static String existsLoggerName = null;
	
	public static Logger getLogger(String name) {
		System.setProperty("logFilename", name);
		if (null != existsLoggerName) {
			LoggerContext context = (LoggerContext) LogManager.getContext(false);
		    Configuration configuration = context.getConfiguration();
		    configuration.removeLogger(existsLoggerName);  
		    context.updateLoggers();
			Configurator.reconfigure();
		} 
		existsLoggerName = name;
		  
		return LogManager.getLogger(name);
		
	}
}
