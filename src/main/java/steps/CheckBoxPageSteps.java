package steps;

import pageObjects.elementsPageObjects.CheckBoxPage;

public class CheckBoxPageSteps extends MainPageSteps {

    CheckBoxPage checkBoxPage = new CheckBoxPage();

    public void clickArrowHomeButton() {
        checkBoxPage.clickArrowHomeButton();
    }
}
