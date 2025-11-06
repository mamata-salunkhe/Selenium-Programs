package seleniumJAVA;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLaunch {
	
	//https://practicetestautomation.com/practice-test-login/
public static void main(String[] args) throws InterruptedException, IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.in/");
	Thread.sleep(4000);
	driver.manage().window().maximize();
	System.out.println("Maximize window");
	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 9000)", " ");
	System.out.println("page is scrolled down");
	
	
	TakesScreenshot scrnshot = (TakesScreenshot)driver;
	File scrnfile = scrnshot.getScreenshotAs(OutputType.FILE);
	File destFile = new File("C:\\Users\\HP\\eclipse-workspace\\Automation_Screenshots\\screenshot1.png");
	FileUtils.copyFile(scrnfile, destFile);
	System.out.println("screenshot has been captured");
	
	driver.navigate().refresh();
	

	WebElement dropdwnbox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
	Select dropdown = new Select(dropdwnbox);
	dropdown.selectByVisibleText("Baby");
	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	wait.until(ExpectedConditions.elementToBeClickable(dropdwnbox));
	
 WebElement text = driver.findElement(By.name("field-keywords"));
 text.sendKeys("Diaper");
 text.sendKeys(Keys.ENTER);
	
	WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
	w.until(ExpectedConditions.titleContains("Diaper"));
	System.out.println("User searched for result...");
	
	TakesScreenshot scrnshot1 = (TakesScreenshot)driver;
	File scrnFile1 = scrnshot1.getScreenshotAs(OutputType.FILE);
	File destFile1 = new File("C:\\Users\\HP\\eclipse-workspace\\Automation_Screenshots\\screenshot2.png");
	FileUtils.copyFile(scrnFile1, destFile1);
	
	WebElement options = driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]"));
	Actions action = new Actions(driver);
	action.moveToElement(options);
	action.click().build().perform();
	System.out.println("mouse hover action performed");
	
	List<WebElement> URLs = driver.findElements(By.tagName("a"));
	int linkCount = URLs.size();
	System.out.println(linkCount);
	for(WebElement URL: URLs) {
		System.out.println(URL.getText());
		
	}
	
//	Actions action1 = new Actions(driver);
//	action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
	driver.close();
}
}
