package pageObjects.elementsPageObjects;

import org.openqa.selenium.By;
import pageObjects.BasePage;

public class UploadDownloadPage extends BasePage {

    private static final String SELECT_FILE_XPATH = "//div[@class='form-file']/input[@id='uploadFile']";
    private static final String DOWNLOAD_XPATH = "//div//a[@id='downloadButton']";
    private static String FILE_PATH = "C:/Users/User/OneDrive/Рабочий стол/qrcode.png";

    public void clickChooseFile(){
        driver.findElement(By.xpath(SELECT_FILE_XPATH)).sendKeys(FILE_PATH);
    }
}
