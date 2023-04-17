package fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.SeleniumMethods;

public class TextField extends AllFields {

    private static final String TEXT_XPATH = "//label[text()='%s']/..//following-sibling::div/input";

    @Override
    public SeleniumMethods setFieldValue(String fieldName, String[] values) throws Exception {
        WebElement textField = driver.findElement(By.xpath(String.format(waitForDisplayed(getXpath(), fieldName))));
        textField.clear();
        textField.sendKeys(values);
        return new SeleniumMethods();
    }

    @Override
    public String getFieldValue(String fieldName) {
        return driver.findElement(By.xpath(String.format(waitForDisplayed(getXpath(), fieldName)))).getText();
    }

    @Override
    protected String getXpath() {
        return TEXT_XPATH;
    }
}
