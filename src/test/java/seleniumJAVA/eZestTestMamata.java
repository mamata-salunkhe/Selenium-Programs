package seleniumJAVA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eZestTestMamata {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://nucleus-apps.iaea.org/nss-oui/collections/relationship");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		
		WebElement search = driver.findElement(By.xpath("//a[contains(text(),'Search ')]"));
		search.click();
		
		Select dropdown = new Select(search);
		dropdown.selectByVisibleText("Relationship Search");
		
		WebElement choosePublication = driver.findElement(By.xpath("//span[@id='choosePublicationId']"));
		choosePublication.click();
		
		WebElement search2 = driver.findElement(By.xpath("//input[@class='form-control form-control-sm']"));
		search2.sendKeys("GSR PART 2");
		
		
		
		
		

	}

}
