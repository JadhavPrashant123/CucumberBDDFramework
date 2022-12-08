package PageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByEmail 
{

	public WebDriver ldriver;

	public SearchCustomerByEmail(WebDriver rDriver) 
	{
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement txtEmailAdd;

	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement searchBtn;

	@FindBy(xpath = "//table[@role='grid']")
	WebElement searchResult;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;

	// Action method
	public void enterEmailAdd(String email) 
	{
		txtEmailAdd.sendKeys(email);
	}

	public void clickOnSearchButton() 
	{
		searchBtn.click();
	}

	public boolean searchCustomerByEmail(String expectedEmailAdd) 
	{
		boolean found = false;

		// Total no of rows in a grid
		int ttlRows = tableRows.size();

		// Total no of columns in a grid
		// int ttlColumns = tableColumns.size();

		for (int i = 1; i <= ttlRows; i++) 
		{
			WebElement webElementEmail = ldriver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();

			if (actualEmailAdd.equals(expectedEmailAdd)) 
			{
				found = true;
			}

		}
		return found;
	}
}