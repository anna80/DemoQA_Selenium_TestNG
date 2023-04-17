package pageObjects.elementsPageObjects;

import org.openqa.selenium.By;
import pageObjects.BasePage;

public class RegistrationFormPage extends BasePage {

    private static final String SUBMIT_XPATH = "//button[@id='submit']";

    public void clickSubmitButton() {
        driver.findElement(By.xpath(SUBMIT_XPATH)).click();
    }
}
