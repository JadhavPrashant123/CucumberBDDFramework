package TestRunner;

//import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//features = ".//Features/Login.feature";
		features = ".//Features/",
		glue = "StepDefinition", 
		dryRun = false, 
		monochrome = true,
		tags = "@sanity", //will Run scenario which is tagged with sanity. Does not matter if it has other tags as well. 
		//plugin = {"pretty", "html:target/cucumber-reports/report_html.html"}
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class TestRun extends AbstractTestNGCucumberTests {

}
