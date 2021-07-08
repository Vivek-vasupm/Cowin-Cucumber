package cucumber.cowin.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//java//cucumber//cowin//feature",
//FILE -->SO NEED DIR PATH(SHOULD BE IN // AND FROM SRC FOLDER)
glue="/Cowin/src/test/java/cucumber/cowin/sd/StepDefenition.java")
//-->JAVA FILE SO JUST ALT+ENTER=PATH IS ENOUGH
public class Runner {

}
