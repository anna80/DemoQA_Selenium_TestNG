package pageObjects;

import org.openqa.selenium.By;

public class ModalDialogsPage extends BasePage {

    private final static String BUTTON_SMALL_MODAL_XPATH = "//button[@id='showSmallModal']";
    private final static String BUTTON_LARGE_MODAL_XPATH = "//button[@id='showLargeModal']";
    private final static String TEXT_LARGE_MODAL_XPATH = "//button[@id='showLargeModal']";
    private final static String TEXT_SMALL_MODAL_XPATH = "//button[@id='showLargeModal']";

    public void clickSmallModal() {
        driver.findElement(By.xpath(waitForDisplayed(BUTTON_SMALL_MODAL_XPATH))).click();
    }

    public void clickLargeModal() {
        driver.findElement(By.xpath(waitForDisplayed(BUTTON_LARGE_MODAL_XPATH))).click();
    }

    public String getSmallText(String fieldName) {
        return driver.findElement(By.xpath(String.format(TEXT_SMALL_MODAL_XPATH, fieldName))).getText();
    }

    public String getLargeText(String fieldName) {
        return driver.findElement(By.xpath(String.format(TEXT_LARGE_MODAL_XPATH, fieldName))).getText();
    }
}
