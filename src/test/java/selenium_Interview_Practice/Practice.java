package selenium_Interview_Practice;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Practice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("button[type^='submit']")).click();
		
		
		WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		searchBox.sendKeys("iphone");
		driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
		
		System.out.println(driver.getTitle());
		
		WebElement totalResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none s-breadcrumb-header-text']//span"));
		System.out.println(totalResult.getText());
		
//		driver.findElement(By.xpath("//span[text()='Get It by Tomorrow']//preceding::input[@type='checkbox']")).click();
		
		WebElement minSider = driver.findElement(By.xpath("//input[@aria-label='Minimum price']"));
		Actions action = new Actions(driver);
		action.clickAndHold(minSider)
		.moveByOffset(1000, 0)//move right
		.release()
		.perform();
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div[class^='puis-card-container'] button")));
//		
//		List<WebElement> result = driver.findElements(By.cssSelector("div[class^='puis-card-container'] button"));
//		System.out.println(result.size());
//		
//		result.get(3).click();
//		System.out.println("Clicked item 3");
//		
//		result.get(4).click();
//		System.out.println("Clicked item 4");
		
		
		
		
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollTo(0,0)");
//		
//		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement searchboxNew = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//		searchboxNew.clear();
//		
//		WebElement dpdwn = driver.findElement(By.id("searchDropdownBox"));
//		js.executeScript("arguments[0].click();", dpdwn);
//		
//		Select select = new Select(dpdwn);
//		select.selectByVisibleText("Baby");
//		searchboxNew.sendKeys("Diaper");
//		
////		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
////		WebElement searchOption = wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='diaper m size']")));
////		searchOption.click();
//
//		
//		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
//		        .withTimeout(Duration.ofSeconds(10))
//		        .pollingEvery(Duration.ofMillis(500))
//		        .ignoring(NoSuchElementException.class)
//		        .ignoring(StaleElementReferenceException.class);
//
//		WebElement suggestion = fluentWait.until(d ->
//		d.findElement(By.xpath("//div[normalize-space()='diaper m size']")));
//
//		suggestion.click();
//		
////		searchboxNew.sendKeys(Keys.ENTER);
//		
//		
//		
////		driver.close();
	}
}
