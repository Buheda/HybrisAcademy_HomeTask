package com.udemy.ciklum.lambda_and_streamsAPI.lecture47_lambdaIntro;

import com.udemy.ciklum.util.LoggerUtil;

public class Human implements Walkable {
	public void walk(){
		LoggerUtil.getLogger().trace("Human walking");
	}
}
