package org.collinsongroup.runner;

import io.cucumber.junit.Cucumber;
    import io.cucumber.junit.CucumberOptions;
    import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"classpath:features"},
    glue = {"org.collinsongroup"},
    plugin = "de.monochromata.cucumber.report.PrettyReports:target/cucumber")
public class CucumberRunner {
}