package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selectors;

public class Day2_WebElements {

	@Test
	public void basicAuth() throws InterruptedException {

		open("https://www.amazon.in/");
			
		$(By.id("elementId"));               // Find element by ID
		$(By.className("class-name"));       // Find element by class name
		$(By.name("field-name"));           // Find element by name attribute
		$(By.tagName("div"));               // Find element by HTML tag
		$(By.linkText("Click me"));         // Find link by exact text
		$(By.partialLinkText("Click"));     // Find link by partial text
		$(By.xpath("//div[@id='myId']"));   // Find element by XPath
		$(By.cssSelector(".my-class"));      // Find element by CSS selector

//		In Selenide, the Selectors class provides a variety of methods to locate web elements beyond standard
//		CSS or XPath selectors. These methods enhance the flexibility and readability of your test scripts.
//		Below is an overview of the key methods available in the Selectors class:
		
		$(Selectors.byAttribute("data-test-id", "login-button")); // Selects elements based on a specific attribute and its value.
		$(Selectors.withText("Welcome"));  //Finds elements containing the specified text as a substring.
		$(Selectors.byText("Submit")); //Locates an element that exactly matches the specified text.
		$(Selectors.byTitle("User Profile")); //Finds elements with a specific title attribute
		$(Selectors.byTagAndText("data-test-id", "login-button")); // locate an element with the tag name that contains the exact text.
		$(Selectors.byTextCaseInsensitive("login-button")); ///Finds elements containing the specified text with CaseInsensitive.
		$(Selectors.byTagName("data-test-id")); // Selects elements based on a specific tag name

		$(Selectors.byId("loginForm")); // Finds elements by their id attribute.
		$(Selectors.byClassName("active")); // Locates elements by their class attribute.
		$(Selectors.byName("username")); //Finds elements by their name attribute
		$(Selectors.byXpath("//div[@class='alert']"));   //Locates elements using an XPath expression.
		$(Selectors.byLinkText("Home")); // Finds anchor elements with the exact link text.
		$(Selectors.byPartialLinkText("Read more")); //  Locates anchor elements containing the specified partial link text.
		$(Selectors.byTagName("footer")); // Finds elements by their tag name.
		$(Selectors.byValue("Search")); // Locates input elements with a specific value attribute.
	}
} 