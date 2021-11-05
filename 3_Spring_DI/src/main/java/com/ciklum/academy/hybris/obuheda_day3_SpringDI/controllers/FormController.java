package com.ciklum.academy.hybris.obuheda_day3_SpringDI.controllers;

import org.springframework.stereotype.Controller;

import com.ciklum.academy.hybris.obuheda_day3_SpringDI.services.ParamsConverterService;
import com.ciklum.academy.hybris.obuheda_day3_SpringDI.services.ParamsConverterServiceImp;


@Controller
public class FormController {
	
	private final ParamsConverterService converterService;

	public FormController(ParamsConverterServiceImp converterService) {
		this.converterService = converterService;
	}

	public String getHobbiesArrToString(String[] hobbies ) {
    	return converterService.getHobbiesArrToString(hobbies);
    }
    
    public String getPhoneCode(int id) {
    	return converterService.getPhoneCode(id);
    }
}
