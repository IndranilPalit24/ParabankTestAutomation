package Hooks;

import ConfigManager.ConfigurationManager;
import DriverManager.PlaywrightManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        PlaywrightManager
                .initBrowser(ConfigurationManager.getBrowser(),
                        ConfigurationManager.getHeadless());
    }

    @After
    public void tearDown(){
        PlaywrightManager.closeBrowser();

    }
}
