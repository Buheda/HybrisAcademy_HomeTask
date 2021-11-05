package com.ciklum.academy.hybris.obuheda_day3_SpringDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	    ServletRegistrationBean bean = new ServletRegistrationBean(
	    	      new ResultTableServlet(), "/result");
	    	    bean.setLoadOnStartup(1);
		
	}
}
