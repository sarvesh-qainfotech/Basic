package com.qainfotech.testobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AutomatesFirstLevel {

	WebDriver driver;
	WebElement basicCourse;
	WebElement greenBox;

	public AutomatesFirstLevel(WebDriver driver) {
		this.driver = driver;
	}

	public void automatingFirstLevel() {

		 basicCourse = driver
				.findElement(By.linkText("Basic Course"));

		basicCourse.click();

		greenBox = driver.findElement(By.className("greenbox"));

		greenBox.click();

		// check the title of 2nd level to ensuring switching on 2nd level
		Assert.assertEquals(driver.getTitle(),
				"Frame Dungeon - Basic Course - T.A.T.O.C",
				"Check level 2 title");

	}

}