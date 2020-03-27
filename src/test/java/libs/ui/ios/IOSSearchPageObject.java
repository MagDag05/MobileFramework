package libs.ui.ios;

import libs.ui.factories.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSSearchPageObject extends SearchPageObject {


    static {
        SEARCH_INIT_ELEMENT = ;
        SEARCH_INPUT = ;
        SEARCH_CANCEL_BUTTON =;
        SEARCH_RESULT_BY_SUBSTRING_TPL = ;
        SEARCH_RESULT_ELEMENT =;
        SEARCH_EMPTY_RESULT_ELEMENT = ;
    }

    public IOSSearchPageObject (RemoteWebDriver driver) {
        super (driver);
    }
}

}
