package com.qainfotech.testobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {

	WebDriver driver;

	public WebDriver openBrowser() {

		return new FirefoxDriver();
	}

	public String setUrl(String url) {

		return url;

	}

	
}
