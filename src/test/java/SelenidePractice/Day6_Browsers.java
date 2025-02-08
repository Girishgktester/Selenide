package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

public class Day6_Browsers {

	@Test
	public void basicCommands() throws InterruptedException {

		open("https://the-internet.herokuapp.com/"); // Open URL

		Selenide.closeWindow(); // Close current window
		Selenide.closeWebDriver(); // Close browser completely
		refresh(); // Refresh page
		back(); // Navigate back
		forward(); // Navigate forward

	}

	@Test
	public void basicConfigurations() throws InterruptedException {

		Configuration.baseUrl = "https://the-internet.herokuapp.com/"; // Set base URL
		open("floating_menu");                             // Open URL
		Configuration.browser = "chrome";                 // Set browser
		Configuration.timeout = 10000;                   // Set timeout (ms)
		Configuration.headless = true;                  // Enable headless mode
		Configuration.screenshots = false;              // Disable screenshots
		Configuration.clickViaJs = true;               // enable javascript click
		Configuration.holdBrowserOpen = true;         // dont quite the driver when execution completed 
		Configuration.savePageSource = false;        // print the page source
		Configuration.reopenBrowserOnFail = true;   // reopen browser when test fails
		Configuration.fastSetValue = true;         // sendkeys using javascript not using selenium inbuilt function

		String browserSize = Configuration.browserSize;
		String recportFolderLocation = Configuration.reportsFolder;
		System.out.println(browserSize);                // get browser size
		System.out.println(recportFolderLocation);     // get where reports are stored
	}
}