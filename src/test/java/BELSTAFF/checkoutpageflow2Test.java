package BELSTAFF;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.base;

public class checkoutpageflow2Test extends base {
	@Test

	public void checkoutTesting() throws IOException, InterruptedException {

		driver = initializedriver();

		pageobjectcheckout pc = new pageobjectcheckout(driver);
		pc.checkout();
		pageobjectproductpage pd = new pageobjectproductpage(driver);
		pd.productpage();

		securecheckoutpageobject sc = new securecheckoutpageobject(driver);
		sc.secure();
		deliverytostorepageobject ds=new deliverytostorepageobject(driver);
		ds.delivertostore();
		
		
		
		
	}
	
			


		
				
			}

