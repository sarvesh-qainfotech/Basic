package com.qainfotech.testobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	
	public WebDriver driver;

	public void openBrowser() {

		driver = new FirefoxDriver();
	}

	public void setUrl(String url) {
		
		driver.get(url);

	}

	public void closeBrowser() {
		driver.close();
	}
}
