package com.ciklum.academy.hybris.obuheda_day3_SpringDI.services;

public class ParamsConverterServiceImp implements ParamsConverterService {

	@Override
	public String getHobbiesArrToString(String[] hobbies) {
		StringBuilder selectedHobbies = new StringBuilder();
		
		String separator = "";
		if (null!=hobbies && hobbies.length>0) {
			for (String hobby : hobbies) {
			    if (hobby != null) {
			    	selectedHobbies.append(separator);
			    	selectedHobbies.append(hobby);			    	
			    	separator = ", ";

			    }
		    } 
		}
		String result = selectedHobbies.toString();
		System.out.println(result);
		
		return result.toString();
	}

	@Override
	public String getPhoneCode(int id) {
		String result = "";

		switch(id) {
		 case 0:
			 result = "+38";
			break;
		 case 1:
			 result = "+7";
		    break;
		 case 2:
			 result = "+375";
		    break;
		 case 3:
			 result = "+373";
		    break;
		 default:
			 result = "+38";
		}	
		
		return result;
	}

}
