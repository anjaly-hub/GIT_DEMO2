package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;

public class base {
	
	public WebDriver driver;
	public WebDriver initializedriver() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\BelstaffTesting\\data.properties");
		prop.load(fis);
		String url=prop.getProperty("url");
		String browsername=prop.getProperty("browser");
		String item=prop.getProperty("searchitem");
		String emailid=prop.getProperty("email");
		 System.out.println(item);

		if(browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\anjal\\chromedriver_win32\\chromedriver.exe");
			//ChromeOptions options=new ChromeOptions();
			//options.addArguments("headless");
			driver= new ChromeDriver();
			
			
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	public void checkforpopup() {
		Set<Cookie>ckies=	driver.manage().getCookies();
		System.out.println(ckies);
				driver.manage().deleteCookieNamed("firstVisitPopup");

		 

		} 

		
		}
	