package steps;

import pageObjects.AlertsPage;


public class AlertsPageSteps extends MainPageSteps {

    AlertsPage alertsPage = new AlertsPage();

    public void clickOnAlertButton(){
        alertsPage.clickOnAlertButton();
    }

    public void clickOnTimeAlertButton(){
        alertsPage.clickOnTimeAlertButton();
    }

    public void clickOnConfirmAlertButton(){
       alertsPage.clickOnConfirmAlertButton();
    }

    public String getAlertText(String fieldName) {
        return alertsPage.getAlertText(fieldName);
    }

    public void clickOnPromtAlertButton(){
       alertsPage.clickOnPromtAlertButton();
    }

    public String getPromtAlertText(String fieldName) {
        return alertsPage.getPromtAlertText(fieldName);
    }

    public void PopupWindowAlert(){
        alertsPage.PopupWindowAlert();
    }
}
