package com.ciklum.academy.hybris.obuheda_day4_SpringMVC.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ciklum.academy.hybris.obuheda_day4_SpringMVC.services.ParamsConverterService;

@Controller
public class ResultController {
	
	@Autowired
	private ParamsConverterService paramsConverterService;
	
	@RequestMapping(value="/result", method = RequestMethod.POST)
	public String getResultPage(@RequestParam(value = "login", required = false, defaultValue = "") String login,
								@RequestParam(value = "password", required = false, defaultValue = "") String password,
								@RequestParam(value = "fullname", required = false, defaultValue = "") String fullname,
								@RequestParam(value = "phone", required = false, defaultValue = "0") Long phone,
								@RequestParam(value = "code", required = false, defaultValue = "0") int code,
								@RequestParam(value = "gender", required = false, defaultValue = "") String gender, 
								@RequestParam(value = "hobbies", required = false, defaultValue = "") String[] hobbies,
								@RequestParam(value = "favcolor", required = false, defaultValue = "") String favcolor,
								Model model
								) {
		model.addAttribute("login", login);
		model.addAttribute("password",password);
		model.addAttribute("fullname", fullname);
		model.addAttribute("phone", paramsConverterService.getPhoneCode(code)+phone.toString());
		model.addAttribute("gender", gender);
		model.addAttribute("hobbies", paramsConverterService.getHobbiesArrToString(hobbies));
		model.addAttribute("login", login);
		model.addAttribute("favcolor", favcolor);
		return "result.jsp";
	}
	
	@RequestMapping(value="result", method = RequestMethod.GET)
	public String getResultPage(){

		return "redirect:/index";
	}
}
