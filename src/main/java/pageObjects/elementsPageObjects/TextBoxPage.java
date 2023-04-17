package pageObjects.elementsPageObjects;

import org.openqa.selenium.By;
import pageObjects.BasePage;

import static utils.ScrollingUtils.scrollToDown;

public class TextBoxPage extends BasePage {

    private static final String SUBMIT_XPATH = "//button[@id='submit']";

    public void clickSubmitButton(){
        driver.findElement(By.xpath(SUBMIT_XPATH)).click();
        scrollToDown(driver);
    }

}
