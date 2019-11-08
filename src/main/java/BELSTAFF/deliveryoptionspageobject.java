package BELSTAFF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class deliveryoptionspageobject {

	public WebDriver driver;

	public deliveryoptionspageobject(WebDriver driver) {
		this.driver = driver;
	}

	private By delToadd = By.xpath("//input[@id='deliverAddress']");
	private By title = By.xpath("//select[@id='dwfrm_singleshipping_shippingAddress_addressFields_title'] ");
	private By firstnamebutton = By
			.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_firstName'] ");
	private By lastnamebutton = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_lastName'] ");
	private By phnumbutton = By.xpath("//input[@id='dwfrm_singleshipping_shippingAddress_addressFields_phone'] ");
	private By countrybutton = By.xpath("//select[@id='dwfrm_singleshipping_shippingAddress_addressFields_country'] ");

	private By addressbutton = By.xpath("//input[@id='intuitive-search']");
	private By place = By.xpath("//li[text()=', Horley, RH6 ...']");
	private By billbutton = By.xpath("//div[@class='f-field-checkbox f-field']//span[@class='fake-checkbox'] ");

	private By continuebutton = By.xpath(" //button[@name='find-address']");
	private By proceedTobillbutton = By.xpath("//button[@name='dwfrm_singleshipping_shippingAddress_save'] ");

	public void deliveryValidations() throws IOException {
		WebElement element3 = driver.findElement(delToadd);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].click()", element3);

		Select s = new Select(driver.findElement(title));
		s.selectByIndex(2);
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\anjal\\BelstaffTesting\\data.properties");
		prop.load(fis);
		String firstname = prop.getProperty("fName");
		String lastname = prop.getProperty("lName");
		String pnum = prop.getProperty("phonenum");
		String addressline = prop.getProperty("address");

		driver.findElement(firstnamebutton).click();
		driver.findElement(firstnamebutton).sendKeys(firstname);
		driver.findElement(lastnamebutton).click();
		driver.findElement(lastnamebutton).sendKeys(lastname);
		driver.findElement(phnumbutton).click();
		driver.findElement(phnumbutton).sendKeys(pnum);
		Select s1 = new Select(driver.findElement(countrybutton));
		s1.selectByVisibleText("United Kingdom");
		driver.findElement(addressbutton).click();
		driver.findElement(addressbutton).sendKeys(addressline);
		driver.findElement(place).click();
		driver.findElement(billbutton).click();
		driver.findElement(continuebutton).click();
		WebElement element2 = driver.findElement(proceedTobillbutton);
		JavascriptExecutor js2 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].click()", element2);

		Set<Cookie> ckies = driver.manage().getCookies();
		driver.manage().deleteCookieNamed("firstVisitPopup");

	}

}
