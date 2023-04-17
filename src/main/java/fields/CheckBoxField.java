package fields;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.SeleniumMethods;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckBoxField extends AllFields {

    private static final String CHECKBOXES = "//li[@class='rct-node rct-node-parent rct-node-expanded']//..//ol//ol//span[text()='%s']";
    private static final String CATEGORY_VALUES = "//li[contains(@class,'rct-node-collapsed')]//span[text()]";


    @Override
    public SeleniumMethods setFieldValue(String fieldName, String[] values) throws Exception {

        Map<String, List<String>> map = new LinkedHashMap<>();

        List<WebElement> categories = driver.findElements(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']//span[text()='" + fieldName + "']"));

        for (WebElement category : categories){
            String categoryName = category.getText();
            map.put(categoryName, null);
        }
        //получаем список значений для каждой категории
        map.forEach((category, categoryValues) -> {
            List<String> categoryValueList = driver.findElements(By.xpath("//li[contains(@class,'rct-node-expanded')]//span[text()='" + fieldName + "']//following::li[contains(@class,'rct-node-expanded')]//span[text()='" + category + "']"))
                    .stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            map.put(category, categoryValueList);
        });
        //кликаем на все значения в каждой категории.
        map.forEach((category, categoryValues) ->{
            categoryValues.forEach(categoryValue -> driver.findElement(By.xpath("//li[contains(@class,'rct-node-expanded')]//span[text()='" + fieldName + "']//following::li[contains(@class,'rct-node-expanded')]//span[text()='" + category + "']/..//input/..//span[text()='" + categoryValues + "']"))
                    .click());
        });
//        if (values.length <= categories.size()) {
//            for (WebElement checkbox : categories) {
//                if (checkbox.isSelected()) {
//                    checkbox.click();
//                }
//            }
//            for (String value : values) {
//                for (WebElement checkbox : categories) {
//                    String ch = checkbox.getText();
//                    if (ch.equals(value)) {
//                        checkbox.click();
//                    }
//                }
//            }
//        } else {
//            throw new Exception("Size of values more than checkboxes values");
//        }
        return new SeleniumMethods();
    }

    @Override
    public String getFieldValue(String fieldName) {
        List<String> checkboxes = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath(String.format(CHECKBOXES,fieldName)));
        for (WebElement element : elements) {
            if (element.isSelected()) {
                checkboxes.add(element.getText());
            }
        }
        return null;
    }

    @Override
    protected String getXpath() {
        return null;
    }
}

