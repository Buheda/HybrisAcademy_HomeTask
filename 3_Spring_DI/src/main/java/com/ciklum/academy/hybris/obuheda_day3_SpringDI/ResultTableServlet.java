package com.ciklum.academy.hybris.obuheda_day3_SpringDI;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ciklum.academy.hybris.obuheda_day3_SpringDI.controllers.FormController;
import com.ciklum.academy.hybris.obuheda_day3_SpringDI.services.ParamsConverterServiceImp;


/**
 * Servlet implementation class ResultTableServlet
 */
public class ResultTableServlet extends HttpServlet {
	
	
	
	public void printOutResultTable(PrintWriter out, HttpServletRequest request) {		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>login form submit Result</title>");
		out.println("<link href='/css/index.css' rel='stylesheet'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table id=resultTable>");
		out.println("	<tr>");
		out.println("		<td>Login: </td>");
		out.println("		<td>"+request.getParameter("login") +"</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Password: </td>");
		out.println("		<td>"+request.getParameter("password") +"</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Full name</td>");
		out.println("		<td>"+request.getParameter("fullname")+"</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Phone</td>");				
		out.println("		<td>"+request.getAttribute("phone")+"</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Gender</td>");
		out.println("		<td>"+request.getAttribute("gender") +"</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Hobbies</td>");
		out.println("		<td>"+request.getAttribute("hobbies") +"</td>");
		out.println("	</tr>");
		out.println("	<tr>");
		out.println("		<td>Favorite color</td>");
		out.println("		<td><div style='width:20px;height:20px;border:1px solid #000;background-color: "+request.getParameter("favcolor") +"'></div></td>");
		out.println("	</tr>");
		out.println("	</table>");
		out.println("</body>");
		out.println("</html>");
	}
	
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

			setRequestAttributes(request);
			PrintWriter output = response.getWriter();
			printOutResultTable(output, request);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("ResultTableServlet get");

			setRequestAttributes(request);
			PrintWriter output = response.getWriter();
			printOutResultTable(output, request);
;	}

}
