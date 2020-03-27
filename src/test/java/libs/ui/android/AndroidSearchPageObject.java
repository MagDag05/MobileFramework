package libs.ui.android;

import libs.ui.factories.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {

    static {
        SEARCH_INIT_ELEMENT = ;
                SEARCH_INPUT = ;
                SEARCH_CANCEL_BUTTON =;
                SEARCH_RESULT_BY_SUBSTRING_TPL = ;
                SEARCH_RESULT_ELEMENT =;
                SEARCH_EMPTY_RESULT_ELEMENT = ;
    }

    public AndroidSearchPageObject (RemoteWebDriver driver) {
        super (driver);
    }
    }
