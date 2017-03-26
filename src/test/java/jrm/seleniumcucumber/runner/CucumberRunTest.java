package jrm.seleniumcucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jrojo on 26/03/17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        glue = "jrm.seleniumcucumber.steps",
        features={"src/test/resources"}
)
public class CucumberRunTest {}
