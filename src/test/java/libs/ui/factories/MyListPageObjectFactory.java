package libs.ui.factories;

import libs.ui.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListPageObjectFactory {

    public static MyListPageObject get(RemoteWebDriver driver) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidMylistsPageObject(driver);
        }
        else { return new IOSMylistsPageObject(driver);}

    }
}
