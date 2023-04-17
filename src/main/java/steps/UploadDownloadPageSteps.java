package steps;

import pageObjects.elementsPageObjects.UploadDownloadPage;

public class UploadDownloadPageSteps extends MainPageSteps {

    UploadDownloadPage uploadPage = new UploadDownloadPage();

    public void clickChooseFile() {
        uploadPage.clickChooseFile();
    }
}
