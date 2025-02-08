package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;

import java.time.Duration;
import java.util.Collection;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class Day9_MouseAndKeyboard {

	@Test
	public void mouseInteractions() throws InterruptedException {

		open("https://the-internet.herokuapp.com/hovers");

		$(element(By.xpath("(//img[@alt='User Avatar'])[1]"))).hover();

		$x("//h5[normalize-space()='name: user1']").shouldHave(Condition.exactText("name: user1"));

		$(element(By.xpath("(//img[@alt='User Avatar'])[2]"))).hover();

		$x("//h5[normalize-space()='name: user2']").shouldHave(Condition.exactText("name: user2"));

		$(element(By.xpath("(//img[@alt='User Avatar'])[3]"))).hover();

		$x("//h5[normalize-space()='name: user3']").shouldHave(Condition.exactText("name: user3"));

	}

	@Test
	public void dragAndDrop() throws InterruptedException {

		open("https://the-internet.herokuapp.com/drag_and_drop");

		SelenideElement source = $(Selectors.byId("column-a"));

		SelenideElement target = $(Selectors.byId("column-b"));

		Actions actions = new Actions(WebDriverRunner.getWebDriver());

		actions.dragAndDrop(source, target).perform();

	}

	@Test
	public void keyBoardActions() throws InterruptedException {

		open("https://the-internet.herokuapp.com/key_presses");

		SelenideElement target = $(Selectors.byId("target"));
		target.pressEnter();
		target.pressTab();
		target.pressEscape();
		target.press("a");
	}

	@Test
	public void alerts() throws InterruptedException {

		open("https://the-internet.herokuapp.com/javascript_alerts");

		SelenideElement target = $(Selectors.byXpath("//button[normalize-space()='Click for JS Alert']"));
		target.click();

		Alert alter = switchTo().alert();
		System.out.println(alter.getText());
		alter.accept();

		SelenideElement jsConfirm = $(Selectors.byXpath("//button[normalize-space()='Click for JS Confirm']"));
		jsConfirm.click();

		System.out.println(alter.getText());
		alter.accept();

		SelenideElement jsPrompt = $(Selectors.byXpath("//button[normalize-space()='Click for JS Prompt']"));
		jsPrompt.click();

		alter.sendKeys("Test");

	}
}