package seleniumJAVA;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSExecutorCommands {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/text-box");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// 1️⃣ Scroll down the page by pixel
		js.executeScript("window.scrollBy(0, 300)");

		// 2️⃣ Enter text using JavaScript
		WebElement FullName = driver.findElement(By.id("userName"));
		js.executeScript("arguments[0].value='Rama Salunkhe';", FullName);

		// 3️⃣ Highlight the element
		js.executeScript("arguments[0].style.border='3px solid red'", FullName);
		Thread.sleep(1000);

		// 4️⃣ Click the submit button using JavaScript
		WebElement submitBtn = driver.findElement(By.id("submit"));
		js.executeScript("arguments[0].click();", submitBtn);

		// 5️⃣ Scroll the element into view
		WebElement output = driver.findElement(By.id("output"));
		js.executeScript("arguments[0].scrollIntoView(true);", output);

		// 6️⃣ Get page title using JavaScript
		String title = js.executeScript("return document.title;").toString();
		System.out.println("PAGE TITLE: " + title);

		// 7️⃣ Zoom out page using JavaScript
		js.executeScript("document.body.style.zoom='80%'");

		// ⬆ Scroll to Bottom of the Page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		// ⬆️ Scroll to Top of the Page
		js.executeScript("window.scrollTo(0,0)");

		Thread.sleep(2000);
		driver.quit();

	}

}
