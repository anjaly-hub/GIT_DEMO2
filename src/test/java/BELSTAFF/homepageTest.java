package BELSTAFF;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.base;

public class homepageTest extends base
{
@Test
	public void homepageTesting() throws IOException {
		
		 driver=initializedriver();
		
		pageobjecthome ph=new pageobjecthome( driver);
		ph.searchvalidation();
		
		
		
	}

	
	
}
