package com.ciklum.academy.hybris.obuheda_day3_SpringDI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		
	}
	
	@Bean
	public ServletRegistrationBean registerResultServlet(){
		
	    ServletRegistrationBean bean = new ServletRegistrationBean(
	    	      new ResultTableServlet(), "/result");
	    	    bean.setLoadOnStartup(1);
	    	   return bean;
	   }
}
