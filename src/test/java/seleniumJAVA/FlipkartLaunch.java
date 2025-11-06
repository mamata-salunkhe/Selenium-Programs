package seleniumJAVA;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartLaunch {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement login = driver.findElement(By.xpath("//*[contains(text(),'Login')][1]"));
		login.click();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(login));
		
		TakesScreenshot screnshot = ((TakesScreenshot)driver);
		File scrnFile = screnshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File ("C:\\Users\\HP\\eclipse-workspace\\Automation_Screenshots\\img01.png");
		FileUtils.copyFile(scrnFile, destFile);
		
		WebElement Email = driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']"));
		Email.sendKeys("thakur.mamata.mt@gmail.com");
		
		driver.navigate().back();
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollBy(0, 5000)", " ");
		System.out.println("window scrolled down");
		
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0, -5000)", "");
		System.out.println("window scrolled up again");
		
		TakesScreenshot srnshot1 = (TakesScreenshot)driver;
		File scrnfile1 = srnshot1.getScreenshotAs(OutputType.FILE);
		File destFile1 = new File ("C:\\Users\\HP\\eclipse-workspace\\Automation_Screenshots\\img02.png");
		FileUtils.copyFile(scrnfile1, destFile1);
		//just for test
		
	
//		driver.close();
	}

}
