package org.collinsongroup.runner;

import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    strict = true,
    features = {"classpath:features"},
    glue = {"org.collinsongroup"},
    plugin = {"json:target/cucumber.json",
        "de.monochromata.cucumber.report.PrettyReports:target/cucumber"})
public class CucumberRunnerTest {
}