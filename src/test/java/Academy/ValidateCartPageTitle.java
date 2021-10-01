package Academy;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePage;
import resources.base;

public class ValidateCartPageTitle extends base {
	public WebDriver driver;
	HomePage homepage;
	
	public static final Logger log=LogManager.getLogger(ValidateCartPageTitle.class.getName());
	@BeforeTest
	public void initialize() throws Exception
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		homepage=new HomePage(driver);
		
	}
	
	@Test
	public void validatePageTitle()
	{
		homepage.clickCart();
		String title=driver.getTitle();
		String expected="Amazon.in Shopping Cart";
		assertEquals(title, expected);
		
	}

	@AfterTest
	public void closeDriver()
	{
		driver.close();
	}
}
