package DriverManager;

import ConfigManager.ConfigurationManager;
import com.microsoft.playwright.*;

public class PlaywrightManager {
    private static final ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static final ThreadLocal<Browser> Browser = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> BrowserContext =  new ThreadLocal<>();
    private static final ThreadLocal<Page> Page = new ThreadLocal<>();

    public static void initBrowser(String browser, boolean headless){
        if(playwright.get()==null){
            try{
                playwright.set(Playwright.create());
            }catch(RuntimeException e){
                playwright.remove();
                throw new IllegalStateException("Could not Start Playwright "+ e);
            }
        }

        switch(browser.toLowerCase()) {
            case "chrome", "msedge":
            Browser.set(playwright.get()
                    .chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(ConfigurationManager
                                    .getHeadless()).setChannel(ConfigurationManager.getBrowser())));
            break;

            case "firefox":
                Browser.set(playwright.get()
                        .firefox()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(ConfigurationManager
                                        .getHeadless()).setChannel(ConfigurationManager.getBrowser())));
            break;

            case "safari":
                Browser.set(playwright.get()
                        .webkit()
                        .launch(new BrowserType.LaunchOptions()
                                .setHeadless(ConfigurationManager
                                        .getHeadless()).setChannel(ConfigurationManager.getBrowser())));
            break;

            default:
                throw new IllegalArgumentException("Unknown Browser "+browser);
        }

        BrowserContext.set(Browser.get().newContext());

        Page.set(BrowserContext.get().newPage());
    }


    public static void closeBrowser(){
        if(Page.get()!= null){
            Page.remove();
        }

        if(BrowserContext.get()!=null){
            BrowserContext.remove();
        }

        if(Browser.get()!=null){
            Browser.remove();
        }

        if(playwright.get()!=null){
            playwright.remove();
        }
    }

}
