package com.zerobank.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\main\\resources\\features",
        glue = "com\\weborders\\step_definitions",
        tags = "@Tester",
        dryRun = false,
        plugin = "html:target/default-report"
)

public class CukesRunner {

}
