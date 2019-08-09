package com.logicgate.sheepadoption.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            features = "/Users/surendra/IdeaProjects/SheepAdoption/src/test/resources/com.logicgate.goatadoption/featurefiles/LogicgateSheepAdoption.feature",
            tags = {"@auto"},
            glue={"com.logicgate.sheepadoption.stepdefinations"},
            plugin={ "pretty", "html:target/cucumber-jvm-reports", "json:target/CucumberTestReport.json"}
    )

            public class sheepAdoptionRunner {


}





