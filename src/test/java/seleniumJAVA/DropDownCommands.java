package seleniumJAVA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

//https://chatgpt.com/share/6924265e-a2d0-8004-bf59-7dc662127c89
public class DropDownCommands {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/select-menu");
		driver.manage().window().maximize();

		// 1. Single select value
		WebElement element = driver.findElement(By.id("oldSelectMenu"));
		Select select = new Select(element);
		select.selectByIndex(2); // Green OR
		select.selectByValue("4"); // purple OR
		select.selectByVisibleText("Black");

		// 2. Multi select with Select Tag
		WebElement multi = driver.findElement(By.id("cars"));
		Select select1 = new Select(multi);
		select1.selectByValue("volvo");
		select1.selectByIndex(2); // selecting Opel AND
		select1.selectByVisibleText("Audi");

		List<WebElement> list = select1.getAllSelectedOptions();
		for (WebElement selectedOptions : list) {
			System.out.println(selectedOptions.getText());
		}
		select1.deselectAll();

		// 3. Handling CUSTOM (non-select) Dropdowns for single value select
		driver.findElement(By.xpath("(//div[@class=' css-tlfecz-indicatorContainer'])[1]")).click();
		WebElement element2 = driver.findElement(By.xpath("//div[contains(text(),'Group 1, option 2')]"));
		System.out.println(element2.getText());
		element2.click();

		// 4. Handling CUSTOM (non-select) Dropdowns for Multi value select
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement multiElementDropdwn = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[contains(@class,'css-1wa3eu0-placeholder')])[2]")));
		multiElementDropdwn.click();

		WebElement multiElement1 = driver.findElement(By.xpath("//div[contains(text(),'Green')]"));
		System.out.println(multiElement1.getText());
		multiElement1.click();

		WebElement multiElement2 = driver.findElement(By.xpath("//div[contains(text(),'Blue')]"));
		System.out.println(multiElement2.getText());
		multiElement2.click();
		driver.quit();

	}

}
