package pageObjects.elementsPageObjects;

import org.openqa.selenium.By;
import pageObjects.BasePage;

public class WebTablesPage extends BasePage {

    public void clickAddButton() {
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        waitForPage("Registration Form");
    }

    public void clickDeleteButton() {
        driver.findElement(By.xpath("//div[@class='action-buttons']//span[@id='delete-record-4']")).click();
    }
}
