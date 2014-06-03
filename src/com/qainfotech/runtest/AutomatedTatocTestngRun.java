package com.qainfotech.runtest;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class AutomatedTatocTestngRun  {

	BaseFixture basefixture = new BaseFixture();

	@BeforeClass
	public void beforeClass() {

		basefixture.initializer();
	}

	@Test
	public void tetscase1() {
		
		basefixture.runTestCases();

	}

	@AfterClass
	public void afterClass() {
		
		basefixture.closer();

	}

}