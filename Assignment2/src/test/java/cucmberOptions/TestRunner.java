package cucmberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(  
		features = "src/test/java/features",
		glue="stepDefinations",
		monochrome =true,
		plugin= {"html:target/cucumber","json:target/cucumber.json","junit:target/cukes.xml"})

public class TestRunner {	

}
