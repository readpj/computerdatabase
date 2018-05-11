package com.herokuapp.computerdatabase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class ProjectWebDriver {

    private static WebDriver webDriver;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                webDriver.manage().deleteAllCookies();
                webDriver.quit();
            }
        });
    }

    @Value("${baseURL}")
    private String baseURL;

    @Value("${browser}")
    private String browser;

    @Value("${webdriver.gecko.driver}")
    private String webDriverGeckoDriverLocation;

    @Value("${chromedriver}")
    private String chromeDriver;

    @PostConstruct
    public void setUpWebDriver() throws IOException {

        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", webDriverGeckoDriverLocation);
            webDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromeDriver);
            webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.get(baseURL);
    }

    public final WebDriver getWebDriver() {
        return webDriver;
    }

}
