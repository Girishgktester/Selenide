package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;

public class Day10_WebDriverRunner {

	@Test
	public void webdriverrunner() throws InterruptedException {

		// Create ChromeOptions (optional - adjust as needed)
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		// Instantiate the ChromeDriver
		WebDriver driver = new ChromeDriver(options);

		// Set the created driver as Selenide's current WebDriver
		WebDriverRunner.setWebDriver(driver);
		open("https://www.amazon.in/");

		// Retrieve the current WebDriver via WebDriverRunner.getWebDriver()
		WebDriver currentDriver = WebDriverRunner.getWebDriver();
		System.out.println("Current URL: " + currentDriver.getCurrentUrl());

		Actions actions = new Actions(currentDriver); // using actions class in Selenide

		WebDriverRunner.closeWebDriver(); // quite driver

		WebDriverRunner.closeWindow(); // close current browser window

		WebDriverRunner.clearBrowserCache(); // clear browser cache

		WebDriverRunner.getAndCheckWebDriver(); // Get the underlying instance of Selenium WebDriver, and assert that
												// it's still alive.

		WebDriverRunner.getSelenideProxy(); // get selenide proxy

		WebDriverRunner.isChrome(); // retuns true is tests are running in chrome

		WebDriverRunner.isEdge(); // retuns true is tests are running in Edge

		WebDriverRunner.isFirefox(); // retuns true is tests are running in Firefox

		WebDriverRunner.isHeadless(); // return true or false for headless browser

		WebDriverRunner.url(); // get current url

		WebDriverRunner.getBrowserDownloadsFolder();

	}

}