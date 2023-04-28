package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cucumber-reports-smoke.html",
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags="@wip", //work in progress
        dryRun = true


)
public class Runner {


}




