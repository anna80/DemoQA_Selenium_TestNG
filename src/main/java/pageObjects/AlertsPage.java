package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage extends BasePage {

    private static final String ALERT_BUTTON_XPATH = "//button[@id='alertButton']";
    private static final String TIME_ALERT_BUTTON_XPATH = "//button[@id='timerAlertButton']";
    private static final String CONFIRM_ALERT_BUTTON_XPATH = "//button[@id='confirmButton']";
    private static final String PROMT_ALERT_BUTTON_XPATH = "//button[@id='promtButton']";
    private static final String ALERT_TEXT_XPATH = "//span[@id='confirmResult'][text()]";
    private static final String PROMT_ALERT_TEXT_XPATH = "//span[@id='promptResult'][text()]";

    public void clickOnAlertButton() {
        driver.findElement(By.xpath(waitForDisplayed(ALERT_BUTTON_XPATH))).click();
    }

    public void clickOnTimeAlertButton() {
        driver.findElement(By.xpath(waitForDisplayed(TIME_ALERT_BUTTON_XPATH))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void clickOnConfirmAlertButton() {
        driver.findElement(By.xpath(waitForDisplayed(CONFIRM_ALERT_BUTTON_XPATH))).click();
    }

    public String getAlertText(String fieldName) {
        return driver.findElement(By.xpath(String.format(ALERT_TEXT_XPATH, fieldName))).getText();
    }

    public void clickOnPromtAlertButton() {
        driver.findElement(By.xpath(waitForDisplayed(PROMT_ALERT_BUTTON_XPATH))).click();
        driver.switchTo().alert().sendKeys("Text");
    }

    public String getPromtAlertText(String fieldName) {
        return driver.findElement(By.xpath(String.format(PROMT_ALERT_TEXT_XPATH, fieldName))).getText();
    }

    public void PopupWindowAlert() {
        driver.switchTo().alert().accept();
    }
}
