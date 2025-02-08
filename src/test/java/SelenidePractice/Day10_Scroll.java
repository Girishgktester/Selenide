package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;

public class Day10_Scroll {

	@Test
	public void scroll() throws InterruptedException {

		open("https://the-internet.herokuapp.com/");

		$(Selectors.byXpath("//a[normalize-space()='Sortable Data Tables']")).scrollTo(); // scroll till element is
																							// visble
		executeJavaScript("window.scrollTo(0, document.body.scrollHeight);"); // Scroll to the bottom of the page using
																				// JavaScript
		executeJavaScript("window.scrollBy(0,300);"); // Scroll to the bottom of the page using JavaScript

		executeJavaScript("arguments[0].scrollIntoView(true);", $("#element2")); // scroll into view

	}

	@Test
	public void basicAuth() throws InterruptedException {

//		open("https://the-internet.herokuapp.com/basic_auth","", "admin" , "admin");

		open("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		System.out.println($(element(By.xpath("//h3[text()='Basic Auth']/following::p"))).text());

	}
}
