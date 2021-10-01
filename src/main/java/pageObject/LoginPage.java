package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	@FindBy(id="ap_email")
	private WebElement emailId;
	
	@FindBy(id ="continue")
	private WebElement continueButton;
	
	@FindBy(id ="ap_password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signIn;
	
	@FindBy(css ="li span.a-list-item")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebElement getEmailId()
	{
		return emailId;
	}
	public void clickContinue()
	{
	      continueButton.click();
	}
	public WebElement getPassword()
	{
		return password;
	}
	
	public void clickSignIn()
	{
		signIn.click();
	}
	
	public String invalidLoginError()
	{
		String errorText=errorMessage.getText();
		return errorText;
	}

}
