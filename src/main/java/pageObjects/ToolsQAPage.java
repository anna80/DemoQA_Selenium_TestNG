package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToolsQAPage extends BasePage{

    private static final String CARDS_XPATH = "//div[@class='card mt-4 top-card']//div[@class='card-body']/h5[text()='%s']";
    private static final String INNER_CARDS_XPATH = "//div[@class='header-text'][text()='%s']";

    public void openMainPage(String testUrl) {
        driver.get(testUrl);
    }

    public void goToSection(String sectionName){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(CARDS_XPATH, sectionName))));
        driver.findElement(By.xpath(String.format(CARDS_XPATH, sectionName))).click();
    }

    public void goToInnerSection(String sectionName){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(INNER_CARDS_XPATH, sectionName))));
        driver.findElement(By.xpath(String.format(INNER_CARDS_XPATH, sectionName))).click();
    }
}
