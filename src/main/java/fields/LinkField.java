package fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.SeleniumMethods;

import java.util.ArrayList;
import java.util.List;

import static utils.ScrollingUtils.scrollToDown;

public class LinkField extends AllFields {

    private static final String LINKS_XPATH = "//a[text()='%s']";

    @Override
    protected String getXpath() {
        return LINKS_XPATH;
    }

    @Override
    public SeleniumMethods setFieldValue(String fieldName, String[] values) throws Exception {
        throw new Exception("Current method is not intended for Web");
    }

    @Override
    public String getFieldValue(String fieldName) {
        WebElement linkElement = driver.findElement(By.xpath(String.format(waitForDisplayed(getXpath(), fieldName))));
        return linkElement.getAttribute("href");
    }
}
