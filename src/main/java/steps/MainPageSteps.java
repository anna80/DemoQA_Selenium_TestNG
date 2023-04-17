package steps;

import pageObjects.MainPage;
import selenium.SeleniumMethods;

public class MainPageSteps extends SeleniumMethods {

    protected MainPage mainPage = new MainPage();

    public void goToPage(String page) {
        mainPage.goToPage(page);
    }

    public void clickOnLink(String fieldName) {
        mainPage.clickOnLink(fieldName);
    }

    public void switchToFirstIframe() {
        mainPage.switchToFirstIframe();
    }

    public void switchToSecondIframe() {
        mainPage.switchToSecondIframe();
    }

    public void switchToDefaultContent() {
        mainPage.switchToDefaultContent();
    }

    public String getFieldValue() {
        return mainPage.getFieldValue();
    }

    public String getPageTitle(String fieldName){
        return mainPage.getPageTitle(fieldName);
    }
}
