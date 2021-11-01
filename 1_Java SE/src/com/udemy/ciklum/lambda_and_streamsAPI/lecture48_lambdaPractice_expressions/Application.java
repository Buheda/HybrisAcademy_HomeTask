package com.udemy.ciklum.lambda_and_streamsAPI.lecture48_lambdaPractice_expressions;

import org.apache.logging.log4j.Logger;

import com.udemy.ciklum.util.LoggerUtil;

@FunctionalInterface
interface ALambdaInterface {
	public void execute();
}

@FunctionalInterface
interface ALambdaCalculationInterface {
	public int compute(int a, int b);
}

@FunctionalInterface
interface ALambdaIntInterface {
	public int execute(int num);
}

@FunctionalInterface
interface AStringLambdaInterface {
	public String execute(String str);
}

@FunctionalInterface
interface AGenericLambdaInterface<T> {
	public T execute(T t);
}

public class Application {
	private static Logger logger = LoggerUtil.getLogger("Lecture48");
	
	public static void main(String[] args) {
		logger.info("example - sayHello");
		lambdaSayHello();
		logger.info("\nexample - lambdaSum");
		lambdaSum(5,6);
		logger.info("\nexample - nonZeroDivide");
		lambdaNonZeroDivide(10, 5);
		logger.info("\nexample - lambdaStringReverse");
		lambdaStringReverse("this is test string");
		logger.info("\nexample - lambdaFactorial");
		lambdaFactorial(4);
	}
	
	static void sayHello() {
		logger.trace("Hello");
	}
	
	static void lambdaSayHello() {
		ALambdaInterface lambda = ()-> {
			logger.trace("Hello");
		};
		
		lambda.execute();
	}
	
	static void example1() {
		lambdaSayHello();
	}
	
	static void lambdaSum(int a, int b) {
		ALambdaCalculationInterface lambdaResult = (arg1, arg2)->arg1+arg2;
		logger.trace(lambdaResult.compute(a, b));
	}
	
	static int sum(int a, int b) {
		return a+b;
	}
	
	static void lambdaNonZeroDivide(int a, int b) {
		ALambdaCalculationInterface lambdaResult = (arg1, arg2)-> {return arg1 == 0 ? 0 : arg1/arg2; };
		logger.trace(lambdaResult.compute(a, b));
	}
	
	public int nonZeroDivide(int a, int b) {
		return a == 0 ? 0 : a/b;
	}
	
	public String reverse(String str) {
		StringBuilder result = new StringBuilder();
		for (int i = str.length()-1; i >=0 ; i--) {
			result.append(str.charAt(i));
		}
		return result.toString();
	}
	
	static void lambdaStringReverse(String str) {
		AGenericLambdaInterface<String> lambdaResult = (arg) -> {
			StringBuilder result = new StringBuilder();
			for (int i = arg.length()-1; i >=0 ; i--) {
				result.append(arg.charAt(i));
			}
			return result.toString();
		};
		logger.trace(lambdaResult.execute(str));
	}
	
	public int factorial(int num) {
		int result = 1;
		for (int i = 1; i<=num; i++) {
			result = result * i;
		}
		
		return result;
	}
	
	static void lambdaFactorial(int num) {
		AGenericLambdaInterface<Integer> lambdaResult = (arg)-> {
			int result = 1;
			for (int i = 1; i<=num; i++) {
				result = result * i;
			}
			
			return result;
		};
		logger.trace(lambdaResult.execute(num));
	}
	
}
