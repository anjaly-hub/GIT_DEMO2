package BELSTAFF;

import java.util.Set;
import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import resources.base;

public class pageobjectproductpage extends base{
	
	
	public WebDriver driver;
	
	
private	By selectsizeicon=By.xpath("//div[contains(@class,'product-variations')]//header[@class='clearfix switcher-title']");
private	By sizedropdowns =By.xpath("//li[contains(@class,'attribute attribute-size')]//li[@id='swatch-S']");
private	By submit=By.xpath("//form[@id='dwfrm_product_addtocart_d0zbbuiwlbul']//button[@id='add-to-cart']  ");
			
private	By checkoutbutton=By.xpath("//span[@class='icon-cart']");
private	By checkout=By.xpath("//a[contains(@class,'mini-cart-link-cart btn-primary text-center block baseline-small')] ");
	
private	By popupwindow=By.xpath("//div[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front first-visit-popup ui-draggable'] ");
	
	public pageobjectproductpage(WebDriver driver) {
		this.driver=driver;
		
	}
	public void productpage() throws InterruptedException {
		
			Set<Cookie>ckies=	driver.manage().getCookies();
			System.out.println(ckies);
					driver.manage().deleteCookieNamed("firstVisitPopup");

			 

			
		driver.findElement(selectsizeicon).click();
		driver.findElement(sizedropdowns).click();
		

		
		
		WebElement element2=driver.findElement(submit);
		JavascriptExecutor js1 = (JavascriptExecutor)driver;

		js1.executeScript("arguments[0].click()", element2);
		
		
		
		Actions a =new Actions(driver);
	
		a.moveToElement(driver.findElement(checkoutbutton)).build().perform();
		Thread.sleep(2000L);
		a.moveToElement(driver.findElement(checkout)).click().build().perform();
	
	}

	}

