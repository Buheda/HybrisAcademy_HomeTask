package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerUtil {
	private static String oldLoggerName = null;
	
	public static Logger getLogger(String name) {
		System.setProperty("logFilename", name);
		if (null != oldLoggerName) {
			LoggerContext context = (LoggerContext) LogManager.getContext(false);
		    Configuration configuration = context.getConfiguration();
		    configuration.removeLogger(oldLoggerName);  
		    context.updateLoggers();
			Configurator.reconfigure();
		} 
		oldLoggerName = name;
		  
		return LogManager.getLogger(name);
		
	}
}
