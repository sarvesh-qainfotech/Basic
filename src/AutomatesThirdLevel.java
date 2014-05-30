import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AutomatesThirdLevel {
	
	public void automatingThirdLevel(WebDriver driver)
	{
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

}
