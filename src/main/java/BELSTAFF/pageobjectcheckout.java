package BELSTAFF;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.base;

public class pageobjectcheckout extends base {

	public WebDriver driver;

	public pageobjectcheckout(WebDriver driver) {
		this.driver = driver;
	}

	By searchicon = By.xpath("//div[@id='header-search-field']//input[@id='q']");
	By item1 = By.xpath("//div[@class='product-info-inside']//a[@class='name-link'][contains(text(),'SHERMAN BELT')] ");
	By popupwindow = By.xpath(
			"//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front first-visit-popup ui-draggable'] ");
	By popup = By.xpath(
			"//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-icon-only ui-dialog-titlebar-close'] ");

	public void checkout() {

		driver.findElement(searchicon).click();

		driver.findElement(searchicon).sendKeys("Belt");
		driver.findElement(searchicon).sendKeys(Keys.ENTER);
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> it = wh.iterator();
		String childid = it.next();

		driver.switchTo().window(childid);
		Set<Cookie> ckies = driver.manage().getCookies();
		System.out.println(ckies);
		driver.manage().deleteCookieNamed("firstVisitPopup");

		WebElement element1 = driver.findElement(item1);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;

		js1.executeScript("arguments[0].click()", element1);

	}

}
