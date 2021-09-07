package apache;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Youcandealwithit
{

	static WebDriver driver;
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.navigate().to("http://www.youcandealwithit.com/borrowers/calculators-and-resources/calculators/budget-calculator.shtml");
		driver.manage().window().maximize();
		driver.findElement(By.id("food")).sendKeys("200");
		driver.findElement(By.id("clothing")).sendKeys("140");
		
	}

}
