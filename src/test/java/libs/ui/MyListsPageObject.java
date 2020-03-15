package libs.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.python.antlr.ast.Str;

public class MyListsPageObject {

     protected static String
    FOLDER_BY_NAME_TPL,
    ARTICLE_BY_TITLE_TPL;

     private static String getFolderXpathByName(String name_of_folder) {
         return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
     }
     private static String getSavedArticleByXpathByTitle(String article_title){
         return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
     }
     public MyListsPageObject(RemoteWebDriver driver) {super(driver);}
     public void openFolderName(String name_of_folder) {
         String folder_name_xpath = getSavedArticleByXpathByTitle(name_of_folder);
         this.waitForElemenAndClick(folder_name_xpath, "Can not find folder by name" + name_of_folder, 5);
     }



}
