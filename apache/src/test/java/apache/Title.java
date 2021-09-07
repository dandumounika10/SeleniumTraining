package apache;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Title 
{

	static WebDriver driver;
	public static void main(String[] args) 
	
	{
		String browser ="GoogleChrome";
					
					if(browser.equalsIgnoreCase("Firefox")) 
					{
						System.setProperty("WebDriver.gecko.driver", "D:\\ChromeDriver\\geckodriver.exe");
						driver = new FirefoxDriver();
					}
					
					else if (browser.equalsIgnoreCase("GoogleChrome")) 
					{
						System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");	
						driver = new ChromeDriver();
					}
					
					else if(browser.equalsIgnoreCase("Opera")) 
					{
						System.out.println("ERROR:UNSUPPORTED BROWSER");
					}
					else if(browser.equalsIgnoreCase("Safari")) 
					{
						System.out.println("ERROR:UNSUPPORTED BROWSER");
					}
					else if(browser.equalsIgnoreCase("Edge")) 
					{
						System.out.println("ERROR:UNSUPPORTED BROWSER");
					}
					
					Title title=new Title();
					title.test();
					
	}
					
		public void test()
		{
			driver.get("https://lsmv-qc-104.agcloud.bz/LSMV/DB?Tenant=AG_AGX_MAIN_DS2");
			driver.manage().window().maximize();
			driver.findElement(By.name("loginForm:username")).sendKeys("dmn");
			driver.findElement(By.name("loginForm:password")).sendKeys("Password@2");
			driver.findElement(By.name("loginForm:signInButtonvisible")).click();
			if (driver.findElements(By.xpath("//span[@id='loginForm:sessionUserid_title']")).size() > 0) 
			{
				
				if (driver.findElement(By.xpath("//span[@id='loginForm:sessionUserid_title']")).isDisplayed()) 
				{
				driver.findElement(By.xpath("//span[text()='Ok']")).click();
				}
				else
				{
				System.out.println("Alert msg is not generated");
				}
			}
			
			driver.getTitle();
		}
	}


