package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static utils.ScrollingUtils.scrollToDown;

public class MainPage extends BasePage {

    private static final String PAGE_XPATH = "//div[@class='element-list collapse show']//span[text()='%s']";
    private static final String WAIT_XPATH = "//div[text()='%s']";
    private static final String LINKS_XPATH = "//a[text()='%s']";
    private static final String FRAME_FIRST_XPATH = "//iframe[@id='frame1']";
    private static final String FRAME_SECOND_XPATH = "//iframe[@id='frame2']";

    public void goToPage(String page) {
        driver.findElement(By.xpath(String.format(PAGE_XPATH, page))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(WAIT_XPATH, page))));
    }

    public String getPageTitle(String fieldName) {
        return driver.findElement(By.xpath(String.format(WAIT_XPATH, fieldName))).getText();
    }

    public void clickOnLink(String fieldName) {
        waitAndClick(driver.findElement(By.xpath(String.format(waitForDisplayed(LINKS_XPATH, fieldName)))));
        scrollToDown(driver);
    }

    public void switchToFirstIframe() {
        WebElement frame = driver.findElement(By.xpath(waitForDisplayed(FRAME_FIRST_XPATH)));
        driver.switchTo().frame(frame);
    }

    public void switchToSecondIframe() {
        WebElement frame = driver.findElement(By.xpath(waitForDisplayed(FRAME_SECOND_XPATH)));
        driver.switchTo().frame(frame);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public String getFieldValue() {
        return driver.findElement(By.xpath(waitForDisplayed("//h1[@id='sampleHeading']"))).getText();
    }
}
