package apache;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actionss {

		 @Test
		public void Actions_1() 
		 {
			 
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in/");
			Actions act=new Actions(driver);
			act.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
			driver.findElement(By.xpath("//span[text()='Sign in']")).click();
			String actTitle=driver.getTitle();
			System.out.println("Actual Title is :"+actTitle);
			String expTitle="Amazon Sign In";
			if(expTitle.contains(actTitle))
			{
				System.out.println("Pass");
			}
			else
			{
				System.out.println("Fail");
			}
			driver.close();
		 }

}
