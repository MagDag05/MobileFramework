package tests;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    private AndroidDriver driver;
    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","AndroidTestDevice");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");
        capabilities.setCapability("app","/Users/home/Documents/GitHub/avt_mob_mac/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void firstTest(){
        WebElement elemToInitSearch = driver.findElementByXPath("//*[contains(@text, 'Search Wikipedia')]");
        elemToInitSearch.click();
        //WebElement elemToEnterSearchLine = driver.findElementByXPath("//*[contains(@text, 'Search…')]");
        WebElement elemToEnterSearchLine = waitForElementPresentByXpath(
                "//*[contains(@text, 'Search…')]",
                "Cannot find search input" //,5
        );
        elemToEnterSearchLine.sendKeys("Java");
        waitForElementPresentByXpath(
                "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='Object-oriented programming language']",
                "Cannot find 'Object-oriented programming language'",
                10
        );
        System.out.println("First test with wait! Well done!");
    }

    private WebElement waitForElementPresentByXpath(String xPath, String errorMessage, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        By by = By.xpath(xPath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private WebElement waitForElementPresentByXpath(String xPath, String errorMessage){
        return waitForElementPresentByXpath(xPath, errorMessage, 5);
    }
}

