package pageObjects.elementsPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

public class CheckBoxPage extends BasePage {

    private static final String ARROW_HOME_XPATH = "//div[@id='tree-node']//button[@title='Toggle']";

    public void clickArrowHomeButton(){
        driver.findElement(By.xpath(ARROW_HOME_XPATH)).click();
    }
}
