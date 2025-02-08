package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.Test;

public class Day1_BrowserCommands {

	@Test
	public void basicAuth() throws InterruptedException {

		open("https://www.google.in/"); // by default opens the browser in Chrome

		System.out.println(title()); // Get the page title of Google

		open("https://www.amazon.in/");

		System.out.println(title()); // Get the page title of Amazon

		back(); // Navigate back

		System.out.println(title()); // Navigated back to Google using back() Method

		forward(); // Navigate forward

		System.out.println(title());

		refresh(); // Refresh the page

		closeWindow(); // close the window

		closeWebDriver(); // quite the webdriver session internally calling driver.quite();

	}
}
