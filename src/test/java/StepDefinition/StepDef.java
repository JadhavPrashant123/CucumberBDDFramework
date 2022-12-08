package StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerByEmail;
import PageObject.SearchCustomerByName;
import Utilities.ReadConfiq;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
//import junit.framework.Assert;

public class StepDef extends BaseClass {

////////////////////////////// USER LOGIN ///////////////////////////////////// 

	private static final OutputType OutputType = null;
	private static final String BYTES = null;

	@Before
	public void setup() throws Exception {
		readConfiq = new ReadConfiq();
		// Log = LogManager.getLogger("StepDef");
		System.out.println("Setup method executed... ");

		String browser = readConfiq.getBrowser();

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
	}

	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {

		loginPG = new LoginPage(driver);
		addNewCustPG = new AddNewCustomerPage(driver);
		searchCustEmailPG = new SearchCustomerByEmail(driver);
		searchCustNamePG = new SearchCustomerByName(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String pass) {
		loginPG.enterEmal(emailadd);
		loginPG.enterPass(pass);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Clicks on Login")
	public void clicks_on_login() {
		loginPG.ClickOnLoginButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true); // pass
		} else {
			Assert.assertTrue(false); // fail
		}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		loginPG.ClickOnLogoutButton();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//////////////////////////// ADD NEW CUSTOMER ///////////////////////////////////////////////

	@Then("User can view Dashboard {string}")
	public void user_can_view_dashboard(String expectedTitle) throws Exception {
		String actualTitle = addNewCustPG.getPageTitle();
		Thread.sleep(2000);

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws Exception {
		addNewCustPG.clickOnCustomersMenu();
		Thread.sleep(2000);
	}

	@When("User click on customers Menu Item")
	public void user_click_on_customers_menu_item() throws Exception {
		addNewCustPG.clickOnCustomersMenuItem();
		Thread.sleep(2000);
	}

	@When("User click on Add new button")
	public void user_click_on_add_new_button() throws Exception {
		addNewCustPG.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addNewCustPG.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Exception {
		// addNewCustPG.enterEmail("test123@gmail.com");
		addNewCustPG.enterEmail(generateEmailId() + "@gmail.com");
		addNewCustPG.enterPassword("test1");
		addNewCustPG.enterFirstName("Prashant");
		addNewCustPG.enterLastName("Jadhav");
		addNewCustPG.enterGender("Male");
		addNewCustPG.addDateOfBirth("08/08/1978");
		addNewCustPG.enterCompanyName("ABCD");
		addNewCustPG.enterAdminComment("Admin Content");
		addNewCustPG.enterManagerOfVendor("Vendor 1");
		Thread.sleep(2000);
	}

	@When("click on Save button")
	public void click_on_save_button() {
		addNewCustPG.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();

		if (bodyTagText.contains(expectedConfirmationMsg)) {
			Assert.assertTrue(true); // Pass
		} else {
			Assert.assertTrue(false); // Fail
		}

	}

	////////////////////// Search Customer by Email //////////////////////////////

	@When("Enter Customer Email")
	public void enter_customer_email() {

		searchCustEmailPG.enterEmailAdd("victoria_victoria@nopCommerce.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Click on search button")
	public void click_on_search_button() {

		searchCustEmailPG.clickOnSearchButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() throws Exception {
		Thread.sleep(2000);
		String expectedEmail = "victoria_victoria@nopCommerce.com";

		if (searchCustEmailPG.searchCustomerByEmail(expectedEmail) == true) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
	}

	////////////////////// Search Customer by Name /////////////////////////////

	@When("Enter customer Firstname")
	public void enter_customer_firstname() {
		searchCustNamePG.enterFirstName("Victoria");
	}

	@When("Enter customer Lastname")
	public void enter_customer_lastname() throws Exception {
		searchCustNamePG.enterLastName("Terces");
		Thread.sleep(2000);
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() throws Exception {

		String expectedName = "Victoria Terces";

		if (searchCustNamePG.searchCustomerByName(expectedName) == true) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);
		Thread.sleep(2000);
	}

	/*@After
	public void teardown() {
		System.out.println("Tear Down method exicuted...");
		driver.quit();
	}

	@BeforeStep
	public void beforeStepDemo() {
		System.out.println("This is before step....");
	}

	@AfterStep
	public void afterStepDemo() {
		System.out.println("This is after step....");
	}*/
	
	@AfterStep
	public void addScreenshot(Scenario scenario)
	{
		if (scenario.isFailed())
		{
			@SuppressWarnings("static-access")
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

		// attach image file report (data, media type, name of the attachment)
		scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
}