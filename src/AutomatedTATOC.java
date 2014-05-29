import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomatedTATOC {

	public static void main(String args[]) throws InterruptedException {

		// create a new instance of firefox browser
		WebDriver driver = new FirefoxDriver();

		// opens the following in browser
		driver.get("http://172.16.1.17/tatoc");

		// finding the link element by its name
		WebElement element = driver.findElement(By.linkText("Basic Course"));

		// click on the "Basic Course" link
		element.click();

		// finding the element by its class name
		element = driver.findElement(By.className("greenbox"));

		// click on the green box link
		element.click();

		// switch  frame
		driver.switchTo().frame("main");

		/*
		 * WebDriverWait D = new WebDriverWait(driver, 10); element =
		 * D.until(ExpectedConditions
		 * .presenceOfElementLocated(By.id("answer")));
		 */

		// finding the element by its ID(BOX 1)
		element = driver.findElement(By.id("answer"));

		// finding the box 1 color for comparision
		String box1Color = element.getAttribute("class");

		// initializing while loop variable by true
		boolean whileLoopVariable = true;

		// It will runs untill the color of both boxes are not matched
		while (whileLoopVariable) {

			// finding the Repaint Box 2 link
			element = driver.findElement(By.linkText("Repaint Box 2"));
			// click on the Repaint Box 2 link
			element.click();

			// swich the child frame of BOX 2
			driver.switchTo().frame("child");

			// finding the element by itsID(BOX 2)
			element = driver.findElement(By.id("answer"));

			// finding the box 2 color for comparision
			String box2Color = element.getAttribute("class");

			// Matching the color of box 1 and box 2
			if (box1Color.equalsIgnoreCase(box2Color)) {

				// switching in to main frame
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");

				// click on the Proceed link
				element = driver.findElement(By.linkText("Proceed"));
				element.click();

				whileLoopVariable = false;
			} else {

				// switch the frame
				driver.switchTo().defaultContent();
				driver.switchTo().frame("main");

			}

		}

		// draging the box into the rectangle by using javascript executer
		JavascriptExecutor js = (JavascriptExecutor) (driver);
		js.executeScript("document.getElementById('div1').innerHTML="
				+ "document.getElementById('drag1').outerHTML");

		// finding the element "proceed" by link text
		element = driver.findElement(By.linkText("Proceed"));

		// click on Proceed link
		element.click();

		// findind the element "Launch Popup Window" by link text
		element = driver.findElement(By.linkText("Launch Popup Window"));

		// click on the link "Launch Popup Window"
		element.click();

		// getting the windowHandler of parent window
		String winHandleBefore = driver.getWindowHandle();

		// switching from parent window to child window
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		// finding the textBox element by Id
		element = driver.findElement(By.id("name"));

		// typing in textBox
		element.sendKeys("sarvesh");

		// finding "submit" link by its ID
		element = driver.findElement(By.id("submit"));

		// click "on submit" link
		element.click();

		// switching controls from child to parent window through windowHandler
		driver.switchTo().window(winHandleBefore);

		// finding the "proceed" link by its id
		element = driver.findElement(By.linkText("Proceed"));

		// click on "proceed" link
		element.click();

		// finding the element "generate  token" by its name
		element = driver.findElement(By.linkText("Generate Token"));

		// click on the "Generate Token" link
		element.click();

		// finding the element "token" by its id;
		element = driver.findElement(By.id("token"));

		// getting the actualy cookie string by removing unwanted text
		String tokenValue = element.getText().substring(7);

		// create a cookie for this page as per as instructions
		Cookie cookie = new Cookie("Token", tokenValue, "/tatoc/basic");

		// set tha cookie
		driver.manage().addCookie(cookie);

		// finding the element "Proceed" by its link name
		element = driver.findElement(By.linkText("Proceed"));

		// click on the "proceed" link
		element.click();

		driver.quit();
	}
}
