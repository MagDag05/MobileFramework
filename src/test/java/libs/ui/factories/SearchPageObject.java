package libs.ui.factories;

import libs.ui.MainPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObject extends MainPageObject {

    protected static String

    SEARCH_INIT_ELEMENT,
    SEARCH_INPUT,
    SEARCH_CANCEL_BUTTON,
    SEARCH_RESULT_BY_SUBSTRING_TPL,
    SEARCH_RESULT_ELEMENT,
    SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject (RemoteWebDriver driver) {super(driver);}

    /*Templates method*/
    private static String getResultSearchElement(String substring) {

        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);

    }
    /*Templates method*/
    public void initSearchInput()
    { this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Can not find and click search init element", 5);
      this.waitForElementAndPresent(SEARCH_INIT_ELEMENT, "Can not find search input after clicking serach init element", 5);
    }
    public void waitForCancelButtonToAppear() {
        this.waitForElementAndPresent(SEARCH_CANCEL_BUTTON, "Can not find search cancel button", 5);
    }
    public void waitForCancelButtonToDisappear() {
        this.waitForElementAndPresent(SEARCH_CANCEL_BUTTON, "Search cancel button still present" 5);
            }
    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Can not find and click search cancel button", 5);
    }
     public void typeSearchLine(String serach_line) {

         this.waitForElementAndSendKeys(SEARCH_INPUT, serach_line, "Can not  find and type in search line" 5);
     }
    public void waitForSearchResult(String substrig) {


    }
}
