package seleniumJAVA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchTo_iFrame {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();

		// 1. By name or ID
		driver.switchTo().frame("frame1");
		WebElement text_in_Frame1 = driver.findElement(By.id("sampleHeading"));
		System.out.println(text_in_Frame1.getText());

		// 2. Exit from frame → back to main page
		driver.switchTo().defaultContent(); // FULLY OUT of all frames

		// 3. By WebElement
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		WebElement text_in_Frame2 = driver.findElement(By.id("sampleHeading"));
		System.out.println(text_in_Frame2.getText());

//		driver.switchTo().parentFrame();  // Go 1 level up only

		driver.quit();

	}

}
