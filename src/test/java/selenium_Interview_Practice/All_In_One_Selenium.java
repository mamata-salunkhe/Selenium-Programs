package selenium_Interview_Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class All_In_One_Selenium {

	public static void main(String[] args) throws IOException {
		
		//🔹 Step 1: Launch browser & open website
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		System.out.println("Test Passed: Step 1: Launch browser & open website");
		
		//Step 2: Get title, URL, and page source
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Current Title : " + driver.getTitle());
		System.out.println("page source : " + driver.getPageSource());
		System.out.println("Test Passed: Step 2: Get title, URL, and page source");
		
		//Step 3: Click JavaScript Alerts and handle all alerts
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'JavaScript Alerts')]"));
		element.click();
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept();
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.dismiss();
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert promtAlert = driver.switchTo().alert();
		promtAlert.sendKeys("I am writing OK");
		promtAlert.accept();
		System.out.println("Test Passed: Step 3: Click JavaScript Alerts and handle all alerts");
		
		//Step 4: Go back & click Dropdown → select options
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),'Dropdown') and @href='/dropdown']")).click();
		WebElement selectDpdwn = driver.findElement(By.id("dropdown"));
		selectDpdwn.click();
		
		Select select = new Select(selectDpdwn);
		select.selectByValue("1");
		select.selectByVisibleText("Option 2");
		System.out.println("Test Passed: Step 4: Go back & click Dropdown → select options");
		
		//🔹 Step 5: Go back & click Frames → iFrame → type text
		
		driver.navigate().back();
		driver.findElement(By.xpath("//a[starts-with(@href,'/frames')]")).click();
		
//		WebElement nestedFrame = driver.findElement(By.xpath("//a[starts-with(@href,'/nested_frames')]"));
//		nestedFrame.click();
//		driver.switchTo().frame("nestedFrame");
		
		WebElement iFrameMain = driver.findElement(By.xpath("//a[starts-with(@href,'/iframe')]"));
		iFrameMain.click();
		
		driver.switchTo().frame("mce_0_ifr"); //switch inside frame via id
		WebElement innerText = driver.findElement(By.xpath("//*[contains(text(),'Your content goes here')]"));
		System.out.println("Test inside frame is: " + innerText.getText());
		driver.switchTo().defaultContent();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().back();
		System.out.println("Test Passed: Step 5: Go back & click Frames → iFrame → type text -> Go Back -->used Implicitely Wait");
		
		//🔹 Step 6: Use JavaScriptExecutor to scroll
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // scroll to bottom
		System.out.println("scrolled till bottom");
		
		js.executeScript("window.scrollTo(0, 0)"); // scroll to top
		System.out.println("scrolled to Top");
		
		js.executeScript("window.scrollBy(0, 1000)");
		System.out.println("scrolled down by pixel");
		
		System.out.println("Test Passed: Step 6: Use JavaScriptExecutor to scroll");
		
		//Step 7: Take screenshot
		
		
		TakesScreenshot scrnshot = (TakesScreenshot)driver;
		File scrnFile = scrnshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\HP\\eclipse-workspace\\Automation_Screenshots\\screenshot1.png");
		FileUtils.copyFile(scrnFile, destFile);
		System.out.println("Test Passed: Step 7: Take screenshot");
		
		//Step 8: Print all links on page
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println("Total number of links count is: " + count);
		for(WebElement AllUrls: links) {
			System.out.println(AllUrls.getText());
		}
		System.out.println("Test Passed: Step 8: Print all links on page");
		
		//🔹 Step 9: Use Keyboard Actions (Actions Class)
		
		WebElement dragAndDrpElement = driver.findElement(By.xpath("//a[starts-with(@href,'/drag_and_drop')]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(dragAndDrpElement));
		dragAndDrpElement.click();

		Actions action = new Actions(driver);
		action.moveToElement(dragAndDrpElement).click().build();
		WebElement dragColumn = driver.findElement(By.id("column-a"));
		WebElement dropColumn = driver.findElement(By.id("column-b"));
		action.dragAndDrop(dragColumn, dropColumn).perform();
		
		System.out.println("Test Passed: 🔹 Step 9: Use Keyboard Actions (Actions Class)");
		
		//Step 10: switch to window
		
		String parentID = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Implicitly wait added
		driver.navigate().to("https://www.amazon.in/"); //additional syntax being added

		String ActualURL = driver.getCurrentUrl();
		String expectedURL = "https://www.amazon.in/";
		if(expectedURL.equals(ActualURL)) {
			System.out.println("Navigation successful");
		}else {
			System.out.println("Navigation failed");
		}
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println("New Window: " + driver.getTitle());
		
		Set<String> childID = driver.getWindowHandles();
		for(String SubTabNavigation:childID) {
			if(!SubTabNavigation.equals(parentID)) {
				driver.switchTo().window(SubTabNavigation);
				System.out.println("Switched to Amazon Window: " + driver.getCurrentUrl());
				break;
			}
		}
		driver.switchTo().window(parentID);
		System.out.println("Test Passed: Step 10: switch to window");
		
		
		//Step 11: Close browser
		driver.quit();
		System.out.println("Test Passed: Step 11: Close browser");
	}

}
