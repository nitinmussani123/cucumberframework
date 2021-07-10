package runners;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import util.Base;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/feature",glue={"stepDefinition"},plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
monochrome = true)
public class Runner2 extends Base {
	
	@BeforeClass
    public static void setup() throws IOException {
		setUp();
	}
	
	@AfterClass
    public static void teardown() throws IOException {
		tearDown();
	 }
}