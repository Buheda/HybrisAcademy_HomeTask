package com.hybrisacademy.ciklum.day1_udemy.lambda_and_streamsAPI.lecture50_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.logging.log4j.Logger;

import com.hybrisacademy.ciklum.day1_udemy.util.LoggerUtil;

public class Application {
	private static Logger logger = LoggerUtil.getLogger("Lecture50");

	public static void main(String[] args) throws IOException {
		example1();
		example2();
		example3();
		example4();
		example5();
		example6();
		example7();
		example8();
		example9();
		example10();
		example11();
	}
	
	static void example1() {
		logger.info("example1");
		IntStream
			.range(0, 10)
			.forEach((x)->logger.trace(x));		
	}
	
	static void example2() {
		logger.info("\nexample2");
		IntStream
			.range(1, 10)
			.skip(5)
			.forEach((x)->logger.trace(x));		
	}

	static void example3() {
		logger.info("\nexample3");
		int sum = IntStream
			.range(1, 5)
			.sum();

		logger.trace(sum);
	}
	
	static void example4() {
		logger.info("\nexample4");
		Stream.of("Hello", "bottle", "Africa")
		.sorted()
		.findFirst()
		.ifPresent((x)->logger.trace(x));	
	}
	
	static void example5() {
		logger.info("\nexample5");
		String[] items = {"car", "computer", "toothpaste", "box", "pencil", "tent", "toy"};
		Stream.of(items)
		.filter((x)->x.startsWith("t"))
		.sorted()
		.forEach((x)->logger.trace(x));			
	}
	
	static void example6() {
		logger.info("\nexample6");
		Arrays.stream(new int[] {2,4,6,8,10})
		.map((x)->x*x)
		.average()
		.ifPresent((x)->logger.trace(x));	
	}
	
	static void example7() {
		logger.info("\nexample7");
		List<String> list = Arrays.asList("Car", "Computer", "Toothpaste", "Box", "Pencil", "Tent", "Toy");
		list.stream()
		.map((x)->x.toLowerCase())
		.filter((x)->x.startsWith("c"))
		.sorted()
		.forEach((x)->logger.trace(x));			
	}
	
	static void example8() throws IOException {
		logger.info("\nexample8");
		Stream<String> lines = Files.lines(Paths.get("files/wordFile.txt"));
		lines
		.filter((x)->x.length()>6)
		.sorted()
		.forEach((x)->logger.trace(x));
		
		lines.close();
	}
	
	static void example9() throws IOException {
		logger.info("\nexample9");
		List<String> words = Files.lines(Paths.get("files/wordFile.txt"))
		.filter(x->x.contains("th"))
		.collect(Collectors.toList());

		words.forEach((x)->logger.trace(x));
	}
	
	static void example10() throws IOException {
		logger.info("\nexample10");
		Stream<String> lines = Files.lines(Paths.get("files/stockDataCsv.txt"));
		int rowCount = (int) lines.map(x->x.split(","))
		.filter(x -> x.length>3)
		.count();
		logger.trace(rowCount);
		lines.close();
	}
	
	static void example11() throws IOException {
		logger.info("\nexample11");
		Stream<String> lines = Files.lines(Paths.get("files/stockDataCsv.txt"));
		lines.map(x->x.split(","))
		.filter(x -> x.length>3)
		.filter(x->Integer.parseInt(x[1].trim()) > 15)
		.forEach((x)->logger.trace("{} {} {}", x[0].trim(), x[1].trim(), x[2].trim()));
		lines.close();
	}
	
}
