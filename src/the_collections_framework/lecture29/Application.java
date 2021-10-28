package the_collections_framework.lecture29;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.logging.log4j.Logger;

import util.LoggerUtil;

public class Application {
	private static Logger logger = null;

	public static void main(String[] args) {
		logger = LoggerUtil.getLogger("Lecture29");
		example1();
		example2();
		example3();
		example4();
		/*example5();
		example6();*/
	}
	
	private static void example1() {
		logger.info("example1 - HashMap");
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("Brave", "ready to face and endure danger or pain; showing courage.");
		dictionary.put("Brilliant", "exceptionally clever or talented.");
		dictionary.put("Joy", "a feeling of great pleasure and happiness.");
		dictionary.put("Confidence", "the feeling or belief that one can rely on someone or something; firm trust.");
		
		for (String word : dictionary.keySet()) {
			logger.trace(word + " -> " + dictionary.get(word));
		}
	}
	
	private static void example2() {
		logger.info("\nexample2 - LinkedHashMap");
		Map<String, String> dictionary = new LinkedHashMap<String, String>();
		dictionary.put("Brave", "ready to face and endure danger or pain; showing courage.");
		dictionary.put("Brilliant", "exceptionally clever or talented.");
		dictionary.put("Joy", "a feeling of great pleasure and happiness.");
		dictionary.put("Confidence", "the feeling or belief that one can rely on someone or something; firm trust.");
		
		for (String word : dictionary.keySet()) {
			logger.trace(word + " -> " + dictionary.get(word));
		}	
	}
	
	private static void example3() {
		logger.info("\nexample3 - entrySet");
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("Brave", "ready to face and endure danger or pain; showing courage.");
		dictionary.put("Brilliant", "exceptionally clever or talented.");
		dictionary.put("Joy", "a feeling of great pleasure and happiness.");
		dictionary.put("Confidence", "the feeling or belief that one can rely on someone or something; firm trust.");
		
		for (Map.Entry<String, String> entry : dictionary.entrySet()) {
			logger.trace(entry.getKey());
			logger.trace(entry.getValue());
		}	
	}
	
	private static void example4() {
		logger.info("\nexample4 - TreeMap");
		Map<String, String> dictionary = new TreeMap<String, String>();
		dictionary.put("Brave", "ready to face and endure danger or pain; showing courage.");
		dictionary.put("Brilliant", "exceptionally clever or talented.");
		dictionary.put("Joy", "a feeling of great pleasure and happiness.");
		dictionary.put("Confidence", "the feeling or belief that one can rely on someone or something; firm trust.");
		
		for (Map.Entry<String, String> entry : dictionary.entrySet()) {
			logger.trace(entry.getKey());
			logger.trace(entry.getValue());
		}	
	}
}
