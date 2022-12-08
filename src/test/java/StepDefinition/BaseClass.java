package StepDefinition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerByEmail;
import PageObject.SearchCustomerByName;
import Utilities.ReadConfiq;
import ch.qos.logback.classic.Logger;

public class BaseClass {
	
	public static WebDriver driver;
	public LoginPage loginPG;
	public AddNewCustomerPage addNewCustPG;
	public SearchCustomerByEmail searchCustEmailPG;
	public SearchCustomerByName searchCustNamePG;
	public static Logger log;
	public ReadConfiq readConfiq;
	
	
	// To generate email address at run time.
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(8));
	}

}
