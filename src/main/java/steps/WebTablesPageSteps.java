package steps;

import pageObjects.elementsPageObjects.WebTablesPage;

public class WebTablesPageSteps extends MainPageSteps {

    WebTablesPage webTablesPage = new WebTablesPage();

    public void clickAddButton() {
        webTablesPage.clickAddButton();
    }

    public void clickDeleteButton() {
        webTablesPage.clickDeleteButton();
    }
}
