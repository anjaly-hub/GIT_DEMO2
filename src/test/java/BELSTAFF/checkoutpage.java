package BELSTAFF;

import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;
public class checkoutpage extends base {
	
	
	//private static final org.apache.logging.log4j.Logger log = LogManager.getLogger(checkoutpageTest.class);
	@Test
	public void initialize() throws IOException {
		driver=initializedriver();
		//log.info("driver is initialized");
	}
	

	public void checkoutTesting() throws IOException, InterruptedException {

		
		pageobjectcheckout pc = new pageobjectcheckout(driver);
		pc.checkout();
		
		pageobjectproductpage pd = new pageobjectproductpage(driver);
		pd.productpage();

		securecheckoutpageobject sc = new securecheckoutpageobject(driver);
		sc.secure();
		deliveryoptionspageobject dp = new deliveryoptionspageobject(driver);
		dp.deliveryValidations();
		
		
		
		
	}
	@Test
	
	public void pricematchingvalidation() {
		By price=By.xpath("//span[@class='value mini-cart-price price-adjusted product-sales-price text-uppercase']  ");
		By subTotal=By.xpath("//td[@class='text-right js-order-total']");

		try {
				//WebElement element1=driver.findElement(price);
				//JavascriptExecutor js1 = (JavascriptExecutor)driver;

			//String orginalPrice=	(String) js1.executeScript(" arguments[0].value", element1);
		String orginalPrice=	driver.findElement(price).getText();
				System.out.println(orginalPrice);
				String expectedPrice= driver.findElement(subTotal).getText();
				System.out.println(expectedPrice);
				Assert.assertEquals(expectedPrice, orginalPrice,"Orginal item price and subtotal are matching");
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex) {
			//WebElement element1=driver.findElement(price);
			//JavascriptExecutor js1 = (JavascriptExecutor)driver;

		//String orginalPrice=	(String) js1.executeScript(" arguments[0].value", element1);
			String orginalPrice=	driver.findElement(price).getText();
			System.out.println(orginalPrice);
			String expectedPrice= driver.findElement(subTotal).getText();
			System.out.println(expectedPrice);
			Assert.assertEquals(expectedPrice, orginalPrice,"Orginal item price and subtotal are matching");
			System.out.println("done");
		}

}
	
	
}
