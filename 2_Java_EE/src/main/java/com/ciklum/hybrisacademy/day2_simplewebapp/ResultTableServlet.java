package com.ciklum.hybrisacademy.day2_simplewebapp;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultTableServlet
 */
public class ResultTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void setRequestAttributes(HttpServletRequest request) {
		String code = "";
		
		try {
			switch(Integer.parseInt(request.getParameter("code"))) {
			 case 0:
				 code = "+38";
				break;
			 case 1:
				 code = "+7";
			    break;
			 case 2:
				 code = "+375";
			    break;
			 case 3:
				 code = "+373";
			    break;
			 default:
				 code = "+38";
			}	
		} catch (NumberFormatException e) {
			System.out.println(e);
			code = "+38";
		}
			
		String phone = code+request.getParameter("phone");

		request.setAttribute("phone", phone);
		request.setAttribute("gender", request.getParameter("gender")!=null?request.getParameter("gender"):"");

		StringBuilder selectedHobbies = new StringBuilder();
		String[] hobbiesList=request.getParameterValues("hobbies");
		
		String separator = "";
		if (null!=hobbiesList && hobbiesList.length>0) {
			for (String hobby : hobbiesList) {
			    if (hobby != null) {
			    	selectedHobbies.append(separator);
			    	selectedHobbies.append(hobby);			    	
			    	separator = ", ";

			    }
		    } 
		}
		String hobbies = selectedHobbies.toString();
		System.out.println(hobbies);
		request.setAttribute("hobbies", selectedHobbies);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResultTableServlet get");

		setRequestAttributes(request);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ResultTableServlet post");

		setRequestAttributes(request);
		
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/result.jsp");
		requestDispatcher.forward(request, response);
	}

}
