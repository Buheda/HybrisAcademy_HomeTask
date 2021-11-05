package com.ciklum.academy.hybris.obuheda_day3_SpringDI;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.ImportResource;

import com.ciklum.academy.hybris.obuheda_day3_SpringDI.controllers.FormController;
import com.ciklum.academy.hybris.obuheda_day3_SpringDI.services.ParamsConverterServiceImp;

@ImportResource("classpath:config.xml")

/**
 * Servlet implementation class ResultTableServlet
 */
public class ResultTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void setRequestAttributes(HttpServletRequest request) {
		String code = "";
		FormController formController = new FormController(new ParamsConverterServiceImp());
		try {
			int id = Integer.parseInt(request.getParameter("code"));
			code = formController.getPhoneCode(id);
		} catch (NumberFormatException e) {
			System.out.println(e);
			code = "+38";
		}
			
		String phone = code + request.getParameter("phone");

		request.setAttribute("phone", phone);
		request.setAttribute("gender", request.getParameter("gender")!=null?request.getParameter("gender"):"");

		
		request.setAttribute("hobbies", formController.getHobbiesArrToString(request.getParameterValues("hobbies")));
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResultTableServlet get");
/*
		setRequestAttributes(request);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResultTableServlet post");

		/*setRequestAttributes(request);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(request, response);*/
	}

}
