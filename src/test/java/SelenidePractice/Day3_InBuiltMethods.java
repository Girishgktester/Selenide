package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

public class Day3_InBuiltMethods {

	@Test
	public void sendKeys() throws InterruptedException {

		open("https://opensource-demo.orangehrmlive.com/");

		$(Selectors.byXpath("//input[@placeholder='Username']")).setValue("admi"); // Clear and set value acts as
																					// sendkeys
		$(Selectors.byXpath("//input[@placeholder='Username']")).append("n"); // append n to the UserName filed admi+n

		$(Selectors.byXpath("//input[@placeholder='Password']")).setValue("admin123");

		$(Selectors.byXpath("//button[@type='submit']")).click(); // click on element same as Selenium

	}

	@Test
	public void pressKeys() throws InterruptedException {

		open("https://opensource-demo.orangehrmlive.com/");

		$(Selectors.byXpath("//button[@type='submit']")).pressEnter(); // Press Enter key

		$(Selectors.byXpath("//input[@placeholder='Username']")).pressTab(); // Press Enter Tab

		$(Selectors.byXpath("//input[@placeholder='Password']")).pressEscape(); // Press Enter Escape

	}

	@Test
	public void selectClass() throws InterruptedException {

		open("https://practice.expandtesting.com/dropdown");

		$(Selectors.byId("dropdown")).selectOption("Option 1"); // Select by visible text

		$(Selectors.byId("dropdown")).selectOption(2); // Select by index

		$(Selectors.byId("dropdown")).selectOptionByValue("1"); // Select by value attribute

		SelenideElement dropdown = $(Selectors.byId("dropdown"));

		String selectedOptionText = dropdown.getSelectedOptionText(); // Retrieve the text of the selected option

		System.out.println(selectedOptionText);
	}

	@Test
	public void radioButton() throws InterruptedException {

		open("https://the-internet.herokuapp.com/checkboxes");

		SelenideElement dropdown = $(Selectors.byXpath("(//input[@type='checkbox'])[1]"));
		dropdown.setSelected(true);  // Check checkbox
		dropdown.setSelected(false);  // Uncheck checkbox
	}

}