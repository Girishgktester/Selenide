package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;

public class Day7_Windows {

	@Test
	public void windowHandling() throws InterruptedException {

		open("https://the-internet.herokuapp.com/windows");

		$(Selectors.byXpath("//a[normalize-space()='Click Here']")).click();

		switchTo().window(0, Duration.ofSeconds(10)); // swicth the control to new window within specified time

		System.out.println(title()); // get page title

		switchTo().window(0); // switch back to parent window

		System.out.println(title()); // get the page title again to make sure landed on the same page

		switchTo().newWindow(WindowType.TAB); // opoen new Tab
	}

	@Test
	public void windowhandels() throws InterruptedException {

		open("https://the-internet.herokuapp.com/windows");

		$(Selectors.byXpath("//a[normalize-space()='Click Here']")).click();

		String parentWindow = WebDriverRunner.getWebDriver().getWindowHandle();

		// Switch to child window
		for (String windowHandle : WebDriverRunner.getWebDriver().getWindowHandles()) {
			if (!windowHandle.equals(parentWindow)) {
				switchTo().window(windowHandle);

				// Perform actions in child window
				System.out.println(title()); // get page title

				// Close child window
				closeWindow();
				break;
			}
		}
	}

	@Test
	public void frames() throws InterruptedException {

		open("https://the-internet.herokuapp.com/iframe");

		switchTo().frame($(By.id("mce_0_ifr")));

		Thread.sleep(3000);

		System.out.println($(By.xpath("//p[text()='Your content goes here.']")).getText());

		switchTo().defaultContent();

	}
}