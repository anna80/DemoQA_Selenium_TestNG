package selenium;

import fields.IFields;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static utils.DriverManager.getDriver;


public class SeleniumMethods {

    protected WebDriver driver = getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private static final String ACTUAL_TEXT_BOX_TABLE_XPATH = "//div[@id='output']//p[@id='%s']";
    private static final String ACTUAL_WEB_TABLE_XPATH = "//div[@class='rt-table']//div[@class='rt-tbody']/div[%s]//div[@class='rt-td']";
    public static Logger logger = LoggerFactory.getLogger(SeleniumMethods.class);


    public String getTextFromTextBoxTableByXpath(String fieldName) {
        String value;
        try {
            WebElement element = driver.findElement(By.xpath(String.format(waitForDisplayed(ACTUAL_TEXT_BOX_TABLE_XPATH, fieldName))));
            value = element.getText();
        } catch (Exception e) {
            return null;
        }
        return value.substring(value.lastIndexOf(":") + 1);
    }

//    public String getTextFromWebTableByXpath(String fieldName) {
//        List<WebElement> values = driver.findElements(By.xpath(String.format(waitForDisplayed(ACTUAL_WEB_TABLE_XPATH, fieldName))));
//        List<String> elements = new ArrayList<>();
//        for(WebElement value : values) {
//            if(!value.getText().isEmpty()){
//                elements.add(value.getText());
//            }
//        }
//        return values.get(0).getText();
//    }

    public List<String> getTextFromWebTableByXpath(String rowNumber) {
        return driver.findElements(By.xpath(String.format(waitForDisplayed(ACTUAL_WEB_TABLE_XPATH, rowNumber)))).stream()
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .collect(Collectors.toList());
    }

    public String getFieldValue(IFields fieldType, String fieldName) {
        return fieldType.getFieldValue(fieldName);
    }

    public SeleniumMethods setFieldValue(IFields fieldType, String fieldName, String[] values) throws Exception {
        fieldType.setFieldValue(fieldName, values);
        return new SeleniumMethods();
    }

    public String checkIsDisplayed(String xpath, String fieldName) {
        waitForTimeout(3000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpath, fieldName))));
        return String.format(xpath, fieldName);
    }

    public String waitForDisplayed(String xpath, String fieldName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpath, fieldName))));
        return String.format(xpath, fieldName);
    }

    public String waitForDisplayed(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return xpath;
    }

    public void waitAndClick(String xpath, String fieldName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(xpath, fieldName)))).click();
    }

    public void waitAndClick(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        }
    }

    public void waitForTimeout(int timeout) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(
//                "$('body').attr('timeout-ready', 0); setTimeout(function(){$('body').attr('timeout-ready', 1)},"
//                        + timeout + ");");
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@timeout-ready='1']")));
//    }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (!(Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")) {
            js.executeScript(
                    "var headID = document.getElementsByTagName('head')[0];" +
                            "var newScript = document.createElement('script');" +
                            "newScript.type = 'text/javascript';" +
                            "newScript.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js';" +
                            "headID.appendChild(newScript);");
            WebDriverWait waitJQ = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            Function<WebDriver, Boolean> jQueryAvailable = WebDriver -> (
                    (Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")
            );
            waitJQ.until(jQueryAvailable);
        }
    }
}
