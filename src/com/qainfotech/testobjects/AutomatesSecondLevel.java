package com.qainfotech.testobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AutomatesSecondLevel {

	WebDriver driver;

	public AutomatesSecondLevel(WebDriver driver) {
		this.driver = driver;

	}

	public void automatingSecondLevel() {

		// switch frame
		driver.switchTo().frame("main");

		WebElement box1 = driver.findElement(By.id("answer"));

		String box1Color = box1.getAttribute("class");

		// It will runs untill the color of both boxes are not matched
		while (true) {

			WebElement repaintBox2Link = driver.findElement(By
					.linkText("Repaint Box 2"));

			repaintBox2Link.click();

			// swich the child frame of BOX 2
			driver.switchTo().frame("child");

			WebElement box2 = driver.findElement(By.id("answer"));

			String box2Color = box2.getAttribute("class");

			if (box1Color.equalsIgnoreCase(box2Color)) {

				// switching in to main frame
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");

				WebElement proceedLink = driver.findElement(By
						.linkText("Proceed"));
				proceedLink.click();

				break;

			} else {

				// switch the frame
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");

			}

		}
		// System.out.println("Title is : "+driver.getTitle());
		// check the title of 3rd level to ensuring switching on 3rd level

		Assert.assertEquals(driver.getTitle(),
				"Drag - Basic Course - T.A.T.O.C", "Incorrect Title");

	}

}
