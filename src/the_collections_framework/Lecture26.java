package the_collections_framework;

import org.apache.logging.log4j.Logger;

import util.LoggerUtil;

public class Lecture26 {
	private static Logger logger = null;

	private static void example1() {
		logger.info("example1");
	}
	
	public static void run() {
		logger = LoggerUtil.getLogger("Lecture26");

			example1();
	}

}
