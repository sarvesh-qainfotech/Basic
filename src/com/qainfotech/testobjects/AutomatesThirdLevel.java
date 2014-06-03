package com.qainfotech.testobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class AutomatesThirdLevel {

	WebDriver driver;
	WebElement proceedLink;

	public AutomatesThirdLevel(WebDriver driver) {
		this.driver = driver;

	}

	public void automatingThirdLevel() {
		// draging the box into the rectangle by using javascript executer
		System.out.println(driver.getTitle());
		JavascriptExecutor js = (JavascriptExecutor) (driver);
		js.executeScript("document.getElementById('div1').innerHTML="
				+ "document.getElementById('drag1').outerHTML");

		 proceedLink = driver.findElement(By.linkText("Proceed"));

		proceedLink.click();

		// check the title of 4th level to ensuring switching on 4th level
		Assert.assertEquals(driver.getTitle(),
				"Windows - Basic Course - T.A.T.O.C","Check level 4 title");
	}

}
