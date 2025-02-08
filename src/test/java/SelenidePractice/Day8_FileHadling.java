package SelenidePractice;

import static com.codeborne.selenide.Selenide.*;
import java.io.File;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

public class Day8_FileHadling {

	@Test
	public void downloadFiles() throws InterruptedException {

		Configuration.downloadsFolder = "target/downloads";

		open("https://the-internet.herokuapp.com/download");

		File downloadedFile = $(Selectors.byText("image1.png")).download();

		System.out.println("Downloaded file is located at: " + downloadedFile.getAbsolutePath());

	}

	@Test
	public void fileUpload() throws InterruptedException {

		open("https://the-internet.herokuapp.com/upload");

		SelenideElement fileInput = $(By.id("file-upload"));

		File fileToUpload = new File("C:\\Users\\user\\Downloads\\image1.png");

		System.out.println("Uploading file from: " + fileToUpload.getAbsolutePath());

		fileInput.uploadFile(fileToUpload);

		SelenideElement uploadButton = $(By.id("file-submit"));
		uploadButton.click();

		$(Selectors.byId("uploaded-files")).shouldBe(Condition.text("image1.png"));
	}
}