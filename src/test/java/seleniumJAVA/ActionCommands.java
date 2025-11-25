package seleniumJAVA;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionCommands {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();

		// creating actions object
		Actions actions = new Actions(driver);

		// mouse over
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Droppable')]"));
		actions.moveToElement(element).perform();

		// Drag & drop
		WebElement DragSource = driver.findElement(By.id("draggable"));
		WebElement DropSource = driver.findElement(By.id("droppable"));
		actions.dragAndDrop(DragSource, DropSource);

		// Right Click
		actions.contextClick(DropSource).perform();

		// navigate to another link
		driver.navigate().to("https://demoqa.com/buttons");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		// 1️⃣ Perform mouse hover and then Double Click
		WebElement button1 = driver.findElement(By.id("doubleClickBtn"));
		actions.moveToElement(button1).perform();
		actions.doubleClick(button1).perform();

		// 2️⃣ Wait for message AFTER double click
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf((WebElement) By.id("doubleClickMessage")));

		// 3️⃣ Verify the message
		WebElement doubleClkMsg = driver.findElement(By.id("doubleClickMessage"));
		String ActualText = doubleClkMsg.getText();
		String ExpectedText = "You have done a double click";

		if (ActualText.equals(ExpectedText)) {
			System.out.println("Test Passed: clicked on DoubleClick button");
		} else {
			System.out.println("Test Failed: failed to double click");
		}
		driver.quit();

	}

}
