package apache;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenTest {
	
	WebDriver driver;

	@BeforeClass
	
	public void systemPath_ddt()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
		
	@Test(dataProvider="loginData")
	public void loginForm(String user, String pwd, String res) 
	{
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("Email")).sendKeys(user);
		driver.findElement(By.id("Password")).si
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.
		
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(res.equals("pass"))
		{
			if(exp_title.equals(act_title))
			{
				
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(res.equals("fail"))
		{
			if(exp_title.equals(act_title))
			{
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}	
		
	}
	
	
	@DataProvider(name="loginData")
	
	public String[] [] getData()
	{
		String loginData[] []=
			{
					{"admin@yourstore.com","admin","pass"},
					{"admin@yourstore.co","admin","fail"},
					{"admin@yourstore.com","an","fail"},
					{"admin","adm","fail"}
			};
		return loginData;
	}
		
		@AfterClass
		public void close_ddt() 
		{
			driver.close();
		}
}