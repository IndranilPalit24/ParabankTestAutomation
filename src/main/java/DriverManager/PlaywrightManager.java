package DriverManager;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DriverManager {
    private static ThreadLocal<Playwright> playwright;
    private static ThreadLocal<Browser> Browser;
    private static ThreadLocal<BrowserContext> BrowserContext;
    private static ThreadLocal<Page> Page;



}
