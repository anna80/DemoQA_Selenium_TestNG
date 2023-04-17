package fields;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.SeleniumMethods;


public abstract class AllFields extends SeleniumMethods implements IFields {

    public void checkIsDisplayed(WebElement el) {
        waitForTimeout(1000);
        wait.until(ExpectedConditions.visibilityOf(el));
    }

    protected void clickOnLink(String fieldName){
    }

    protected abstract String getXpath();

}
