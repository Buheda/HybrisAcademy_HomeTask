package com.udemy.ciklum.lambda_and_streamsAPI.lecture47_lambdaIntro;

import com.udemy.ciklum.util.LoggerUtil;

public class Robot implements Walkable {
	public void walk(){
		LoggerUtil.getLogger().trace("Robot walking");
	}
}
