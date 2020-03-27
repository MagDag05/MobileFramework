package libs.ui.ios;

import libs.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {

        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
    }
 public IOSMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
 }

}
