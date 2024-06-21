package cucumberTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumberTest",glue="naukriStepDefination")

public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	

	
}
