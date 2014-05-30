package com.qainfotech.testobjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AutomatesFourthLevel {
	
	public void automatingFourthLevel(WebDriver driver){
		WebElement launchPopupWindow = driver.findElement(By
				.linkText("Launch Popup Window"));

		launchPopupWindow.click();

		// getting the windowHandler of parent window
		String winHandlerParent = driver.getWindowHandle();

		// switching from parent window to child window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		WebElement popupTextBox = driver.findElement(By.id("name"));

		popupTextBox.sendKeys("sarvesh");

		WebElement submitLink = driver.findElement(By.id("submit"));

		submitLink.click();

		// switching controls from child to parent window through windowHandler
		driver.switchTo().window(winHandlerParent);

		WebElement proceedLink = driver.findElement(By.linkText("Proceed"));

		proceedLink.click();

		// check the title of 5th level to ensuring switching on 5th level
		Assert.assertEquals("Check level 5 title",
				"Cookie Handling - Basic Course - T.A.T.O.C", driver.getTitle());
	}

}
