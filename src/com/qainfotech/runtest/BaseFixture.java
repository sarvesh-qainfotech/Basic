package com.qainfotech.runtest;



import com.qainfotech.testobjects.AutomatesFirstLevel;
import com.qainfotech.testobjects.AutomatesSecondLevel;
import com.qainfotech.testobjects.AutomatesThirdLevel;
import com.qainfotech.testobjects.AutomatesFourthLevel;
import com.qainfotech.testobjects.AutomatesFifthLevel;
import com.qainfotech.testobjects.Browser;

public class BaseFixture {

	
	Browser browser = new Browser();
	AutomatesFirstLevel level1 = new AutomatesFirstLevel();
	AutomatesSecondLevel level2 = new AutomatesSecondLevel();
	AutomatesThirdLevel level3 = new AutomatesThirdLevel();
	AutomatesFourthLevel level4 = new AutomatesFourthLevel();
	AutomatesFifthLevel level5 = new AutomatesFifthLevel();
	
	
	public void initializer()
	{
		browser.openBrowser();
		browser.setUrl("http://172.16.1.17/tatoc");
	}
	
	
	public void runTestCases()
	{
		level1.automatingFirstLevel(browser.driver);
		level2.automatingSecondLevel(browser.driver);
        level3.automatingThirdLevel(browser.driver);
		level4.automatingFourthLevel(browser.driver);
		level5.automatingFifthLevel(browser.driver);
	}
	
	public void closer()
	{
		browser.closeBrowser();
	}


	

}
