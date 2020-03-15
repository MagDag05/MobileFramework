package libs.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPageObject {

    protected RemoteWebDriver driver;
    public MainPageObject (RemoteWebDriver driver) {this.driver = driver;}

    private WebElement waitForElementPresent(By by, String errorMessage, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private WebElement waitForElementPresent(By by, String errorMessage){
        return this.waitForElementPresent(by, errorMessage, 5);
    }
    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = this.waitForElementPresent(by, error_message,timeoutInSeconds);
        element.click();
        return element;
    }
    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = this.waitForElementPresent(by, error_message,timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent (By by, String errorMessage, long timeoutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage +"\n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInseconds){
        WebElement element = waitForElementPresent(by, error_message, timeoutInseconds);
        element.clear();
        return element;
    }
    protected void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width/2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x,start_y)
                .waitAction(timeOfSwipe)
                .moveTo(x, end_y)
                .release().perform();
    }
    protected void swipeUpQuick(){
        swipeUp(200);
    }
    protected void swipeUpToFindElement(By by, String error_message, int max_swipes) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if(already_swiped > max_swipes) {waitForElementPresent(by, "Can not find element by swiping up. \n" +error_message, 0 );
                return;}
            swipeUpQuick();
            ++ already_swiped;
        }
    }
    protected void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(
                by,
                error_message,
                10);

        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int uppur_y = element.getLocation().getY();
        int lower_y = uppur_y + element.getSize().getHeight();
        int middle_y = (uppur_y + lower_y) /2;
        TouchAction action = new TouchAction(driver);
        action.press(right_x, middle_y)
                .waitAction(150)
                .moveTo(left_x, middle_y)
                .release().perform();
    }
    private int getAmountOfElements(By by) {

        List elements = driver.findElements(by);
        return elements.size();
    }

    private void assertElementNotPresent(By by, String error_message) {
        int amounmt_of_elements = getAmountOfElements(by);
        if (amounmt_of_elements > 0) {
            String default_message = "An element" + by.toString() + "  supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }

        private String waitForElementAndGetAtribute(By by, String attribute, String error_message, long timeooutInSeconds) {
            WebElement element = waitForElementPresent(by, error_message, timeooutInSeconds);
            return element.getAttribute(attribute);
        }


    }
}
