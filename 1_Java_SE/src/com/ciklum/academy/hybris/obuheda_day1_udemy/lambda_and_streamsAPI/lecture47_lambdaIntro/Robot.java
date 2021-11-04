package com.ciklum.academy.hybris.obuheda_day1_udemy.lambda_and_streamsAPI.lecture47_lambdaIntro;

import com.ciklum.academy.hybris.obuheda_day1_udemy.util.LoggerUtil;

public class Robot implements Walkable {
	public void walk(){
		LoggerUtil.getLogger().trace("Robot walking");
	}
}
