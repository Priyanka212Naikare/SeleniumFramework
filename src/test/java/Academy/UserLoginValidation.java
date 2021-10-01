package Academy;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.*;
import resources.base;

public class UserLoginValidation extends base{
	public WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	
	
  
  @Test(dataProvider = "getData")
  public void loginValidation(String username,String password) {
	  driver.get(prop.getProperty("url"));
	  homepage=new HomePage(driver);
	  loginpage =new LoginPage(driver);
	  homepage.clickSinginIcon();
	  loginpage.getEmailId().sendKeys(username);
	  loginpage.clickContinue();
	  loginpage.getPassword().sendKeys(password);
	  loginpage.clickSignIn();
	  String expectedError="To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.";
	  String actualError=loginpage.invalidLoginError();
	  assertEquals(actualError.trim(),expectedError );
	  
  }
  @BeforeTest
  public void beforeTest() throws Exception {
	  driver=initializeDriver();
	 
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  
  @DataProvider
  public Object getData()
  {
	  Object[][] obj=new Object[2][2];
	  
	  obj[0][0]="abc@rediff.com";
	  obj[0][1]="abc";
	  
	  obj[1][0]="xyz@rediff.com";
	  obj[1][1]="xyz";
	  
	  return obj;
	  
	  
  }

}
