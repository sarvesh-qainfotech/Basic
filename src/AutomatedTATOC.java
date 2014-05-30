import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutomatedTATOC {

	public static void main(String args[]) throws InterruptedException {

		// Create a firefox driver instance and opens following link
		WebDriver driver = new FirefoxDriver();

		driver.get("http://172.16.1.17/tatoc");

		new AutomatesFirstLevel().automatingFirstLevel(driver);

		new AutomatesSecondLevel().automatingSecondLevel(driver);

		new AutomatesThirdLevel().automatingThirdLevel(driver);

		new AutomatesFourthLevel().automatingFourthLevel(driver);

		new AutomatesFifthLevel().automatingFifthLevel(driver);

		// close the firefox instance
		driver.close();

	}
}
