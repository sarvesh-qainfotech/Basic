package com.qainfotech.runtest;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//main testng class

public class AutomatedTatocTestngRun  {

	BaseFixture basefixture = new BaseFixture();

	// it wll run before the class
	@BeforeClass
	public void beforeClass() {

		basefixture.initializer();
	}

	// test cases
	@Test
	public void tetscase1() {
		
		basefixture.runTestCases();

	}

	// it will run after the class
	@AfterClass
	public void afterClass() {
		
		basefixture.closer();

	}

}