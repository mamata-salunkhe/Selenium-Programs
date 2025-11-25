package seleniumJAVA;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Handling_commands {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		// ✅ Example 1: Handle Simple Alert
		WebElement simpleAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"));
		simpleAlert.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

		// ⚠️ Example 2: Confirmation Alert (OK and Cancel)
		WebElement AlertConfirm = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"));
		AlertConfirm.click();
		Alert alert2 = driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();

		// 📝 Example 3: Prompt Alert (Send Text Input)
		WebElement PromptAlert = driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"));
		PromptAlert.click();
		Alert alert3 = driver.switchTo().alert();
		System.out.println(alert3.getText());
		alert3.sendKeys("Yes I cofirmed");
		alert3.accept();

		driver.quit();

	}

}
