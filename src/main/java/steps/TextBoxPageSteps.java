package steps;

import pageObjects.elementsPageObjects.TextBoxPage;

public class TextBoxPageSteps extends MainPageSteps {

    TextBoxPage textBoxPage = new TextBoxPage();

    public void clickSubmitButton() {
        textBoxPage.clickSubmitButton();
    }
}
