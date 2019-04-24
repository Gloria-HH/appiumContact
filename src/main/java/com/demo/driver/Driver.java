package com.demo.driver;

import com.demo.config.GlobalConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Driver {

    private static AppiumDriver appiumDriver;
    private final static Driver driver=new Driver();

    public static Driver getInstance() {
        return driver;
    }

    public static void start() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        GlobalConfig globalConfig = GlobalConfig.load();
        globalConfig.getAppium().getCapabilities().keySet().forEach(key -> {
            Object value = globalConfig.getAppium().getCapabilities().get(key);
            desiredCapabilities.setCapability(key, value);
        });
        URL remoteUrl = null;
        try {
            remoteUrl = new URL(globalConfig.getAppium().getUrl());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        appiumDriver = new AndroidDriver(remoteUrl, desiredCapabilities);
        appiumDriver.manage().timeouts().implicitlyWait(globalConfig.getAppium().getWaitTime(), TimeUnit.SECONDS);
    }

    public String getPlatform() {
        return appiumDriver.getCapabilities().getCapability(CapabilityType.PLATFORM_NAME).toString();
    }


    public WebElement find(By by) {
        return appiumDriver.findElement(by);
    }

    public static void quit() {
        appiumDriver.quit();
    }

    public static AppiumDriver getAppiumDriver() {
        return appiumDriver;
    }


}
