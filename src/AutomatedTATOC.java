import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomatedTATOC {

	public static void main(String args[]) throws InterruptedException {

		// create a constructor of startAutomation class
		startAutomation automation = new startAutomation();

		// automate fisrt level
		automation.automateFirstLevel();

		// automate second level
		automation.automateSecondLevel();

		// automate third level
		automation.automateThirdLevel();

		// automate fourth level
		automation.automateFourthLevel();

		// automate fifth level
		automation.automateFifthLevel();

		// close browser
		automation.closeBrowser();

	}
}

class startAutomation {

	WebDriver driver;

	// Default Constructor which trigger the firefox with the source URL
	startAutomation() {

		driver = new FirefoxDriver();

		driver.get("http://172.16.1.17/tatoc");
	}

	public void automateFirstLevel() {

		WebElement basicCourse = driver
				.findElement(By.linkText("Basic Course"));

		basicCourse.click();

		WebElement greenBox = driver.findElement(By.className("greenbox"));

		greenBox.click();

		// check the title of 2nd level to ensuring switching on 2nd level
		Assert.assertEquals("Check level 2 title",
				"Frame Dungeon - Basic Course - T.A.T.O.C", driver.getTitle());

	}

	public void automateSecondLevel() {
		// switch frame
		driver.switchTo().frame("main");

		WebElement box1 = driver.findElement(By.id("answer"));

		String box1Color = box1.getAttribute("class");

		// initializing while loop variable by true
		boolean whileLoopVariable = true;

		// It will runs untill the color of both boxes are not matched
		while (whileLoopVariable) {

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
				whileLoopVariable = false;
			} else {

				// switch the frame
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");

			}

		}

		// check the title of 3rd level to ensuring switching on 3rd level
		Assert.assertEquals("Check level 3 title",
				"Drag - Basic Course - T.A.T.O.C", driver.getTitle());

	}

	public void automateThirdLevel() {

		// draging the box into the rectangle by using javascript executer
		JavascriptExecutor js = (JavascriptExecutor) (driver);
		js.executeScript("document.getElementById('div1').innerHTML="
				+ "document.getElementById('drag1').outerHTML");

		WebElement proceedLink = driver.findElement(By.linkText("Proceed"));

		proceedLink.click();

		// check the title of 4th level to ensuring switching on 4th level
		Assert.assertEquals("Check level 4 title",
				"Windows - Basic Course - T.A.T.O.C", driver.getTitle());

	}

	public void automateFourthLevel() {

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

	public void automateFifthLevel() {

		WebElement generateTokenLink = driver.findElement(By
				.linkText("Generate Token"));

		generateTokenLink.click();

		WebElement tokenValueBox = driver.findElement(By.id("token"));

		// getting the actual cookie string by removing unwanted text
		String tokenValue = tokenValueBox.getText().substring(7);

		Cookie cookie = new Cookie("Token", tokenValue, "/tatoc/basic");

		driver.manage().addCookie(cookie);

		WebElement proceedLink = driver.findElement(By.linkText("Proceed"));

		proceedLink.click();

		// checking the course completion page
		Assert.assertEquals("Check course completion page", "End - T.A.T.O.C",
				driver.getTitle());

	}

	public void closeBrowser() {
		driver.quit();
	}

}
