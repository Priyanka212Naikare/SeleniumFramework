package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	
	@FindBy(css = "div#nav-cart-count-container")
	private WebElement cart;
	
	@FindBy(css = "span#nav-link-accountList-nav-line-1")
	private WebElement signinIcon;

	@FindBy(linkText = "MOVIES")
	WebElement movies;

	@FindBy(linkText = "CRICKET")
	WebElement cricket;

	@FindBy(linkText = "SPORTS")
	WebElement sports;
	
	@FindBy(css="a.mailicon")
	private WebElement emailIcon;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void clickCart()
	{ 
		cart.click();
	}
	
	
	public void clickSinginIcon()
	{
		signinIcon.click();
	}
}
