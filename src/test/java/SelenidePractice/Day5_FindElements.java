package SelenidePractice;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.conditions.Enabled;

public class Day5_FindElements {

	@Test
	public void collectionoperations() {
		open("https://the-internet.herokuapp.com/");

		// $ refers to findElement
		// $$ refers to findElements

		ElementsCollection collections = $$(Selectors.byTagName("a"));
		System.out.println(collections.size());
		collections.shouldHave(CollectionCondition.size(46)); // Wait for exact number of elements
		collections.shouldHave(CollectionCondition.sizeGreaterThan(45)); // Wait for exact number of elements
		collections.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(46)); // Wait for exact number of elements
		collections.shouldHave(CollectionCondition.sizeLessThanOrEqual(46)); // Wait for exact number of elements
		collections.shouldHave(CollectionCondition.sizeNotEqual(47)); // Wait for exact number of elements
	}

	@Test
	public void collcetionOperations() {

		open("https://the-internet.herokuapp.com/");

		// Find elements containing "Add/Remove Elements"
		ElementsCollection containsText = $$(Selectors.byXpath("//a[normalize-space()='Add/Remove Elements']"))
		    .filter(Condition.text("Add/Remove Elements")); // Fixed the text to match exactly

		// Print the elements found (using proper toString conversion)
		System.out.println("Elements containing text: " + containsText.texts());

		// Find elements with exact text "A/B Testing"
		ElementsCollection exactText = $$(Selectors.byXpath("//a[normalize-space()='A/B Testing']"))
		    .filter(Condition.exactText("A/B Testing"));

		// Print the elements found
		System.out.println("Elements with exact text: " + exactText.texts());

		// Find all elements and filter by text
		ElementsCollection elements = $$(Selectors.byXpath("//a"));

		// Find all elements containing specific text (fixed the text string)
		elements.filterBy(Condition.text("A/B Testing"))
		    .forEach(element -> System.out.println("Found element with text: " + element.getText()));
		
		
		ElementsCollection addRemoveLinks = $$("a")
			    .filter(Condition.text("Add/Remove Elements"));
			System.out.println("Add/Remove links: " + addRemoveLinks.texts());

			// Find elements with exact text
			ElementsCollection abTestingLinks = $$("a")
			    .filter(Condition.exactText("A/B Testing"));
			System.out.println("A/B Testing links: " + abTestingLinks.texts());

			// Print all links containing specific text
			$$("a").filterBy(Condition.text("A/B Testing"))
			    .forEach(element -> System.out.println("Found link: " + element.getText()));
		
		// few more generic examples
		
		$$(".item")
		    .filter(Condition.visible)
		    .filter(Condition.text("Important"));

		// Using filterBy()
		$$(".item").filterBy(Condition.visible).filterBy(Condition.text("Important"));

		// For specific element attributes
		$$(".item")
		    .filter(Condition.visible)
		    .filter(Condition.attribute("data-status", "active"))
		    .filter(Condition.text("Important"));

		// For form elements
		$$("input")
		    .filter(Condition.visible)
		    .filter(Condition.enabled)
		    .filter(Condition.value("test"));

		// Finding elements with specific classes
		$$(".item")
		    .filter(Condition.visible)
		    .filter(Condition.cssClass("active"));	
	}
}
