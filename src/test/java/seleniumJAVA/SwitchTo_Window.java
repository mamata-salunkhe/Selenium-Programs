package seleniumJAVA;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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

public class SwitchTo_Window {
	public static void main(String[] Args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();

		String ParentWindow = driver.getWindowHandle();
		System.out.println("Main window: " + driver.getTitle());

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		System.out.println("New Tab: " + driver.getTitle());

		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println("New Window: " + driver.getTitle());

		// NOW capture window handles
		Set<String> childWindows = driver.getWindowHandles();

		for (String childID : childWindows) {
			if (!childID.equals(ParentWindow)) {
				driver.switchTo().window(childID); // amazon
				break;
			}
		}
		System.out.println("Title of current window: " + driver.getTitle());

		driver.switchTo().window(ParentWindow);
		if (driver.getTitle().contains("DEMOQA")) {
			System.out.println("Test passed: Switched to Parent Window- Yes");
		} else {
			System.out.println("Test Failed");
		}

		driver.quit();

	}
}
