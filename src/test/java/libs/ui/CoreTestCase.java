package libs.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase extends TestCase {

 protected RemoteWebDriver driver;
 @Override
    protected void setUP() throws Exception
 {
     super.setUP();
     driver = Platform.getInstance().getDriver();
     this.rotateScreenPortrait();
     this.skipWelcomePageForIOSApp();
     this.openWikiWebPageForMobileWeb();

      }
@Override
    protected  void tearDown() throws Exception
{
    driver.quit();
    super.tearDown();
}

 protected  void rotateScreenPortrait() {
     if (driver instanceof AppiumDriver) {
         AppiumDriver driver = (AppiumDriver) this.driver;
         driver.rotate(ScreenOrientation.PORTRAIT);
     } else {
         System.out.println("Method rotateScreenPortrait() does nothing for platform " + Platform.getInstance().getPlatformVar());
     }
 }
     protected void rotateScreenLandscape () {
         if (driver instanceof AppiumDriver) {
             AppiumDriver driver = (AppiumDriver) this.driver;
             driver.rotate(ScreenOrientation.LANDSCAPE);
         } else {
             System.out.println("Method rotateScreenLandscape() does nothing for platform " + Platform.getInstance().getPlatformVar());
         }
     }

         protected void backGroundApp ( int seconds){
             if (driver instanceof AppiumDriver) {
                 AppiumDriver driver = (AppiumDriver) this.driver;
                 driver.runAppInBackground(seconds);
             } else {
                 System.out.println("Method backGroundApp() does nothing for platform " + Platform.getInstance().getPlatformVar());
             }}

             private void openWikiWebPageForMobileWeb() {
                if (Platform.getInstance().isMW()) { driver.get("https://en.m.wikipedia.org");}
                else {
                    System.out.println("Method openWikiWebPageForMobileWeb() do nothing for Platform " + Platform.getInstance().getPlatformVar());
                }

             }

             private void skipWelcomePageForIOSApp() {
                 if (Platform.getInstance().isIOS()) {
                     WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
                     WelcomePageObject.clickSkip();
                 }
             }

         }


