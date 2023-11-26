package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class YouTubeTest {
    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName"," UCB diplomado");
        config.setCapability("appium:platformVersion"," 9.0");
        config.setCapability("appium:appPackage","com.google.android.youtube ");
        config.setCapability("appium:appActivity"," com.google.android.apps.youtube.app.watchwhile.InternalWatchWhileActivity");
        config.setCapability("platformName"," Android");
        config.setCapability("appium:automationName","uiautomator2 ");
        mobile = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
    }

    @Test
    public void verify() throws InterruptedException {

        //buscar video
        mobile.findElement(By.xpath("")).sendKeys();


        //verificacion
        String expectedResult = mobile.toString();
        String actualResult =  mobile.findElement(By.id("com.google.android.youtube:id/result")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR! ");
    }


    @AfterEach
    public void closeApp(){
        mobile.quit();
    }
}
