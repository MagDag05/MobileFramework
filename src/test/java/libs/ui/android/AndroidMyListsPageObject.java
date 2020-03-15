package libs.ui.android;

import libs.ui.factories.MyListPageObjectFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {

        FOLDER_BY_NAME_TPL = "xpath://*[@text='{FOLDER_NAME}']";
        ARTICLE_BY_TITLE_TPL = "xpath://*[@text='{TITLE}']";
    }
 public AndroidMyListsPageObject (RemoteWebDriver driver) {
        super(driver);
 }

}
