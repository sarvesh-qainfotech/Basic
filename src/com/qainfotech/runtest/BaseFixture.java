package com.qainfotech.runtest;

import org.openqa.selenium.WebDriver;

import com.qainfotech.testobjects.AutomatesFifthLevel;
import com.qainfotech.testobjects.AutomatesFirstLevel;
import com.qainfotech.testobjects.AutomatesFourthLevel;
import com.qainfotech.testobjects.AutomatesSecondLevel;
import com.qainfotech.testobjects.AutomatesThirdLevel;
import com.qainfotech.testobjects.Browser;

public class BaseFixture {
	
	Browser browser = new Browser();
	WebDriver driver;
	AutomatesFirstLevel level1;
	AutomatesSecondLevel level2;
	AutomatesThirdLevel level3;
	AutomatesFourthLevel level4;
	AutomatesFifthLevel level5;

	public void initializer() {
		driver = browser.openBrowser();
		driver.get(browser.setUrl("http://172.16.1.17/tatoc"));
		level1 = new AutomatesFirstLevel(driver);
		level2 = new AutomatesSecondLevel(driver);
		level3 = new AutomatesThirdLevel(driver);
		level4 = new AutomatesFourthLevel(driver);
		level5 = new AutomatesFifthLevel(driver);

	}

	public void runTestCases() {
		level1.automatingFirstLevel();
		level2.automatingSecondLevel();
		level3.automatingThirdLevel();
		level4.automatingFourthLevel();
		level5.automatingFifthLevel();

	}

	public void closer() {
		driver.close();	}

}
