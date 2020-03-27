package libs.ui.factories;

import libs.ui.Platform;
import libs.ui.android.AndroidArticlePageObject;
import libs.ui.ios.IOSArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ArticlPageObjectFactory {

    public static ArticlePageObject get(RemoteWebDriver driver){
        if (Platform.getInstance().isAndroid()){
            return new AndroidArticlePageObject(driver);
        }
        else {return new IOSArticlePageObject(driver);}
    }
}
