package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement email;

	@FindBy (xpath = "//input[@id='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement loginBtn;

	@FindBy(linkText = "Logout")
	WebElement logout;

	public void enterEmal(String emailadd)
	{
		email.clear();
		email.sendKeys(emailadd);
	}

	public void enterPass(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}

	public void ClickOnLoginButton()
	{
		loginBtn.click();
	}

	public void ClickOnLogoutButton()
	{
		logout.click();
	}

}