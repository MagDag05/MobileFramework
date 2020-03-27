package libs.ui.factories;

import libs.ui.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlePageObject {

    protected static String

            TITLE,
            FOOTER_ELEMENT,
            OPTION_BUTTON,
            OPTION_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPIT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,


    public ArticlePageObject(RemoteWebDriver driver) {
    }
    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Can not find article on page!", 15);    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");}
        else {return title_element.getAttribute("name");}
    }


}
