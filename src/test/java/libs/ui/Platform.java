package libs.ui;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";
    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";
    public static Platform instance;

    private Platform() {
    }

    public static Platform getInstance() {
        if (instance == null) {
            instance = new Platform();
        }
        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {
        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            return new AndroidDriver<org.openqa.selenium.WebElement>(URL, this.getAndroidDesireCapabilities());
           else if (this.isIOS()) {
                return new IOSDriver<org.openqa.selenium.WebElement>(URL, this.getIOSDesireCapabilities());}
           else if (this.isMW()) {
                return new ChromeDriver(this.getMWChromeOptions());
                            }
           else {throw  new Exception("Can not detect type of driver. Platform value:  " + this.getPlatformVar());}

        }
    }

    private boolean isAndroid() {
        return isPlatform(PLATFORM_ANDROID);
    }

    private boolean isIOS() {
        return isPlatform(PLATFORM_IOS);
    }

    private boolean isMW() {
        return isPlatform(PLATFORM_MOBILE_WEB);
    }


    private DesiredCapabilities getAndroidDesireCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "D:/GitHub/MobileFramework/apks/apks/org.wikipedia.apk");
        return capabilities;
    }
    private DesiredCapabilities getIOSDesireCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "IOS");
        capabilities.setCapability("deviceName", "IphoneSE");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("app", "D:/GitHub/MobileFramework/apks/apks/org.wikipedia.apk");
        return capabilities;
    }

    private ChromeOptions getMWChromeOptions() {
        Map<String, Object> deviceMetrics = new HashMap<String, Object>();
        deviceMetrics.put("width", 360);
        deviceMetrics.put("height", 640);
        deviceMetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("deviceMetrtics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("windows-size=340,640");
        return chromeOptions;
    }
    private boolean isPlatform (String my_platrform) {

        String platform = this.getPlatformVar();
        return  my_platrform.equals(platform);
            }
  public String getPlatformVar() {
        return System.getenv("PLATFORM");
  }

}
