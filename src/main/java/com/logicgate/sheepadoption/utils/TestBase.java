package com.logicgate.sheepadoption.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    public static Properties prop;


    public TestBase() {

        try{

            prop = new Properties();
            FileInputStream fis = new FileInputStream("/Users/surendra/IdeaProjects/SheepAdoption/src/test/resources/conf/devqe/application.properties");
            prop.load(fis);
        }
        catch (IOException e) {
            e.getMessage();
        }

    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "/users/surendra/downloads/chromedriver");
            driver = new ChromeDriver();

        }
        else
        {
            System.setProperty("webdriver.chrome.driver", "/users/surendra/downloads/gecodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(Utils.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));



    }
}
