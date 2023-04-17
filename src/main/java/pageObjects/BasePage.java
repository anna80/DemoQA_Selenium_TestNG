package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import selenium.SeleniumMethods;


public abstract class BasePage extends SeleniumMethods {

    protected void waitForPage(String pageName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//div[text()='%s']", pageName))));
    }
}
