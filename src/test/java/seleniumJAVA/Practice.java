package seleniumJAVA;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Practice {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		String parent = driver.getWindowHandle();
		String text = "Sorry, we just need to make sure you're not a robot. For best results, please make sure your browser is accepting cookies.";
	
			if(driver.findElement(By.xpath("//p[@class='a-last']")).getAttribute("Sorry, we just need to make sure you're not a robot. For best results, please make sure your browser is accepting cookies.") != null) {
				driver.navigate().refresh();
				System.out.println("url refreshed");
			}
			else {
				System.out.println("continue testing without refresh");
			}
		
		List<WebElement> URLs = driver.findElements(By.tagName("a"));
		int urlCount = URLs.size();
		System.out.println("no. of URLS" + urlCount);
		for(WebElement url : URLs) {
			System.out.println(url.getText());	
			System.out.println("TC01 passed---------------------------------------------");
		}
		
		
		WebElement backToTop = driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", backToTop );
		
		System.out.println("scrollbar worked---------------------------------------");
		backToTop.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeClickable(backToTop));
		
//		System.out.println("wait condition worked--------------");
		
		TakesScreenshot scrnshot = (TakesScreenshot)driver;
		File scrnsfile = scrnshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\HP\\eclipse-workspace\\Automation_Screenshots\\ss2.png");
		FileUtils.copyFile(scrnsfile, destFile);
		
		System.out.println("screenshot taken----------------------------------------");
		
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]"));
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click().build().perform();
		
		System.out.println("mousehover worked---------------------------------");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		System.out.println("implicitly wait worked--------------------------");
		
		WebElement options = driver.findElement(By.id("searchDropdownBox"));
		Select dropdown = new Select(options);
		dropdown.selectByVisibleText("Baby");
		
		System.out.println("dropdown selection worked----------------");
		
		driver.close();
		driver.quit();
		System.out.println("TC passed successfully-----------------END");
		

		
		
		
		
	}
}
