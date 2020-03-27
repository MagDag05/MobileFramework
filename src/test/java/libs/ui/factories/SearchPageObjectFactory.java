package libs.ui.factories;

import libs.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {

    public static SearchPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().Android()) {
            return new AndroidPageSearchObject(driver);
        }
        else if (Platform.getInstance().isIOS()) {
            return new IOSPageSearchObject(driver);
        }
        else {return new MWSearchPageObject()(driver));}


    }

}
