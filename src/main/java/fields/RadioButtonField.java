package fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.SeleniumMethods;

import java.util.List;

public class RadioButtonField extends AllFields {

    private static final String VALUE = "//div[text()='Do you like the site?']/..//div/label[text()='%s']";

    @Override
    public SeleniumMethods setFieldValue(String fieldName, String[] values) throws Exception {
        List<WebElement> categories = driver.findElements(By.xpath("//div[text()='Do you like the site?']/..//input"));
        if (values.length == 1 && !categories.isEmpty()) {
            WebElement value = driver.findElement(By.xpath(String.format(getXpath(), values[0])));
            if (!value.isSelected()) {
                value.click();
            }
        } else {
            throw new Exception("Values can`t be 0 or more than one");
        }
        return new SeleniumMethods();
    }

    @Override
    public String getFieldValue(String fieldName) {
        return null;
    }

    @Override
    protected String getXpath() {
        return VALUE;
    }
}