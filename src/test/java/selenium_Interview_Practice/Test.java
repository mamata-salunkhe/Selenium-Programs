package selenium_Interview_Practice;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.amazon.in/");
		driver.get("https://www.amazon.in/s?bbn=81107432031&rh=n%3A81107432031%2Cp_85%3A10440599031&_encoding=UTF8&content-id=amzn1.sym.58c90a12-100b-4a2f-8e15-7c06f1abe2be&pd_rd_r=0619fa33-a6f4-412c-89cd-2843b84f0272&pd_rd_w=eC9f4&pd_rd_wg=CciVJ&pf_rd_p=58c90a12-100b-4a2f-8e15-7c06f1abe2be&pf_rd_r=F4JEM2EPQWHYDTBXFVTR&ref=pd_hp_d_atf_unk");
		Thread.sleep(4000);
		driver.manage().window().maximize();
		System.out.println("Maximized window");
		
//		WebElement element2 = driver.findElement(By.xpath("//span[contains(text(),'Air conditioners')]"));
		WebElement element3 = driver.findElement(By.xpath("//a[contains(text(),'Go to the Amazon.in home page to continue shopping')]"));
		Actions action = new Actions(driver);
		action.moveToElement(element3);
		action.click().build().perform();
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Cruise 1 Ton 3 Star Inverter Split AC with 7-Stage Air Filtration (100% Copper, Auto Convertible, PM 2.5 Filter, 2024 Model, CWCVBH-VQ1W123, White)')]"));
		if(element.isDisplayed()) {
			//*[contains(text(),'Cruise 1 Ton 3 Star Inverter Split AC with 7-Stage Air Filtration (100% Copper, Auto Convertible, PM 2.5 Filter, 2024 Model, CWCVBH-VQ1W123, White)')]//following::span[10]	
			WebElement priceElement = driver.findElement(By.xpath("//*[contains(text(),'Cruise 1 Ton 3 Star Inverter Split AC with 7-Stage Air Filtration (100% Copper, Auto Convertible, PM 2.5 Filter, 2024 Model, CWCVBH-VQ1W123, White)')]//following::span[10]"));
		    String price = priceElement.getText();
		    System.out.println(price);
		
		}else {
			System.out.println("TC failed");
		}
driver.close();
driver.quit();
	}

}
