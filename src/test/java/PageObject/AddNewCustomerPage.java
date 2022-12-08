package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
	public WebDriver ldriver;
	
	public AddNewCustomerPage(WebDriver rDriver)
	{
		ldriver = rDriver;
		PageFactory.initElements(ldriver, this);
	}
	
	// Find elements on web page
	@FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomer_menu;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomer_menuItem;
	
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnAddnew;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	
	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement listItemAdministrators;
	
	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
	WebElement listItemForumModerators;
	
	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement listItemGuests;
	
	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;
	
	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement listItemVendors;
	
	@FindBy(xpath = "//select[@id='VendorId']")
	WebElement dropdownVendorMgr;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement MaleGender;
	
	@FindBy(xpath = "//input[@id='Gender_Female']")
	WebElement FeMaleGender;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement txtDob;
			
	@FindBy(xpath = "//input[@id='Company']")
	WebElement txtCompanyName;
	
	@FindBy(xpath = "//textarea[@id='AdminComment']")
	WebElement txtAdminContent;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;
	
	// Action Methods for WebElements
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	public void clickOnCustomersMenu()
	{
		lnkCustomer_menu.click();
	}
	
	public void clickOnCustomersMenuItem()
	{
		lnkCustomer_menuItem.click();
	}
	
	public void clickOnAddnew()
	{
		btnAddnew.click();
	}
	
	public void enterEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void enterFirstName(String firstname)
	{
		txtFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname)
	{
		txtLastName.sendKeys(lastname);
	}
	
	/*public void addCustomerRoles()
	{
		txtCustomerRoles.click();
	}*/
	
	public void enterManagerOfVendor(String value)
	{
		Select drop = new Select(dropdownVendorMgr);
		drop.selectByVisibleText(value);
	}
	
	public void enterGender(String gender)
	{
		if (gender.equals("Male"))
		{
			MaleGender.click();
		}
		else if(gender.equals("Female"))
		{
			FeMaleGender.click();
		}
		else
		{
			MaleGender.click();
		}
	}
	
	public void addDateOfBirth(String dob)
	{
		txtDob.sendKeys(dob);
	}
	
	public void enterCompanyName(String compname)
	{
		txtCompanyName.sendKeys(compname);
	}
	
	public void enterAdminComment(String comment)
	{
		txtAdminContent.sendKeys(comment);
	}
	
	public void clickOnSave()
	{
		btnSave.click();
	}
}
