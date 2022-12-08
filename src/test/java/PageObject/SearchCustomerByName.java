package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByName 
{

	public WebDriver ldriver;

	public SearchCustomerByName(WebDriver rDriver) 
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//input[@id='SearchFirstName']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='SearchLastName']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;

	// Action Methods for First Name
	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}

	// Action Methods for Last Name
	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public boolean searchCustomerByName(String expectedName) 
	{
		boolean found = false;

		// Total no of rows in a grid
		int ttlRows = tableRows.size();

		// Total no of columns in a grid
		// int ttlColumns = tableColumns.size();

		for (int i = 1; i <= ttlRows; i++) 
		{
			WebElement webElementName = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[3]"));
			String actualName = webElementName.getText();

			if (actualName.equals(expectedName)) 
			{
				found = true;
			}

		}
		return found;
	}

}
