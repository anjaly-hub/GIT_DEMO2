package BELSTAFF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.base;

public class securecheckoutpageobject extends base {
	
	public  WebDriver driver;
	
	public securecheckoutpageobject(WebDriver driver) {
		this.driver=driver;
	}
	private	By emailadd=By.xpath("//input[@id='dwfrm_login_username']");
	private	By submitbutton=By.xpath("//button[@name='dwfrm_login_searchcustomer']");
	
	
	public void secure() throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\anjal\\BelstaffTesting\\data.properties");
		prop.load(fis);
		String emailaddress=prop.getProperty("email");
		
		driver.findElement(emailadd).sendKeys(emailaddress);
		driver.findElement(submitbutton).click();
		
	}

}
