package com.qainfotech.runtest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qainfotech.testobjects.AutomatesFifthLevel;
import com.qainfotech.testobjects.AutomatesFirstLevel;
import com.qainfotech.testobjects.AutomatesFourthLevel;
import com.qainfotech.testobjects.AutomatesSecondLevel;
import com.qainfotech.testobjects.AutomatesThirdLevel;
import com.qainfotech.testobjects.Browser;

public class AutomatedTatocTestngRun {

	Browser browser = new Browser();
	AutomatesFirstLevel level1 = new AutomatesFirstLevel();
	AutomatesSecondLevel level2 = new AutomatesSecondLevel();
	AutomatesThirdLevel level3 = new AutomatesThirdLevel();
	AutomatesFourthLevel level4 = new AutomatesFourthLevel();
	AutomatesFifthLevel level5 = new AutomatesFifthLevel();

	@BeforeClass
	public void beforeClass() {
		browser.openBrowser();
		browser.setUrl("http://172.16.1.17/tatoc");

	}

	@Test
	public void tetscase1() {
		level1.automatingFirstLevel(browser.driver);
		level2.automatingSecondLevel(browser.driver);
		level3.automatingThirdLevel(browser.driver);
		level4.automatingFourthLevel(browser.driver);
		level5.automatingFifthLevel(browser.driver);
	}

	@AfterClass
	public void afterClass() {
		browser.closeBrowser();
	}

}