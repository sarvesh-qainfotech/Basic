package com.qainfotech.testobjects;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AutomatesFirstLevel {

	WebDriver driver;
	public AutomatesFirstLevel(WebDriver driver) {
		this.driver = driver;
	}

	public void automatingFirstLevel() {

		WebElement basicCourse = driver
				.findElement(By.linkText("Basic Course"));

		basicCourse.click();

		WebElement greenBox = driver.findElement(By.className("greenbox"));

		greenBox.click();

		// check the title of 2nd level to ensuring switching on 2nd level
		Assert.assertEquals("Check level 2 title",
				"Frame Dungeon - Basic Course - T.A.T.O.C", driver.getTitle());

	}

}