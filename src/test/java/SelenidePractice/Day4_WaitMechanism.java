package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;

import org.testng.annotations.Test;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.WebDriverRunner;

public class Day4_WaitMechanism {

	@Test
	public void visibilityChecks() throws InterruptedException {

		open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		

		$x("//input[@placeholder='Username']").shouldBe(Condition.visible); // Wait until element becomes visible

																									// defining timeuot
		$x("//input[@placeholder='xyz']").shouldNotBe(Condition.visible); // Wait until element becomes invisible

		$x("//label[normalize-space()='Username']").shouldHave(Condition.text("Username")); // Check element text

		$x("//button[normalize-space()='Login']").shouldNotHave(Condition.text("Error")); // Check element doesn't have
																							// text

		$x("//label[normalize-space()='Username']").shouldBe(Condition.exactTextCaseSensitive("")); // text shooud match with case sensitive
		
		$x("//label[normalize-space()='Username']").shouldBe(Condition.oneOfExactTexts("Username"));  // Text contains
		
	}
	
	@Test
	public void customwaitconditions() {

		open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// default timout is 4 seconds
		Configuration.timeout = 6000; // set the custome timeout to 6 seconds
		Configuration.pageLoadTimeout = 30000; // 30 seconds
		Configuration.pollingInterval = 200; // 200 milliseconds
		$x("//input[@placeholder='error']").shouldBe(Condition.hidden, Duration.ofSeconds(10)); // Waits up to 10 seconds for the element to become hidden														
		$x("//input[@placeholder='Username']").shouldBe(Condition.visible, Duration.ofSeconds(10)); // another way of defining custom wait

	}

	
	
	@Test
	public void elementStateChecks() {
		
		open("https://demos.jquerymobile.com/1.4.5/checkboxradio-checkbox/");
		
		$x("//input[@id='checkbox-v-2a']").shouldBe(Condition.enabled); // Check if element is enabled
		$("//input[@id='checkbox-v-2a']").shouldBe(Condition.disabled); // Check if element is disabled
		$x("//input[@id='checkbox-v-2a']").shouldBe(Condition.checked); // Check if element is enabled
		$x("//input[@id='checkbox-v-2a']").shouldBe(Condition.value("One")); // Check if element is enabled
		
	}
}
