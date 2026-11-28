package Runners.LoginPageRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/features/login.feature",
        glue = {"Hooks", "LoginPageStepDefn"}
        

)
public class LoginPageRunner extends AbstractTestNGCucumberTests {
}
