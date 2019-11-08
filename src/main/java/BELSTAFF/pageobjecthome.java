package BELSTAFF;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class pageobjecthome {

	public WebDriver driver;

	public pageobjecthome(WebDriver driver) {
		this.driver = driver;
	}

	By searchicon = By.xpath("//div[@id='header-search-field']//input[@id='q'] ");
	By productlist = By.xpath("//ul[@id='product-search-result-items']//a[@class='name-link']");
	By productlistonpage = By.xpath("//li[@class='js-keyboard-clickable js-product-search-tab search-tab-item search-tab-active h3']  ");
	By fourthproduct = By.xpath("//div[@class='single-column-layout']//li[4]");
	By firstrow = By.xpath("//div[@class='single-column-layout']//li[@class='js-grid-tile loaded']");

	public void searchvalidation() throws FileNotFoundException {
		/*
		 * Properties prop = new Properties(); FileInputStream fis = new
		 * FileInputStream("C:\\Users\\anjal\\BelstaffTesting\\data.properties"); String
		 * item1 = prop.getProperty("item");
		 */

		driver.findElement(searchicon).click();

		driver.findElement(searchicon).sendKeys("Belt");
		driver.findElement(searchicon).sendKeys(Keys.ENTER);
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		String childid = it.next();

		driver.switchTo().window(childid);
		int numbers = driver.findElements(productlist).size();

		String value = Integer.toString(numbers);
		System.out.println(numbers);

		String listname = driver.findElement(productlistonpage).getText();
		System.out.println(listname);

		Assert.assertTrue(listname.contains(value));
		System.out.println("Listed products are same as displayed products");

		System.out.println(driver.findElement(fourthproduct).isDisplayed());
		int rowitems = driver.findElements(firstrow).size();
		Assert.assertEquals(4, rowitems);
		System.out.println("4 items are displayed");

	}

}
