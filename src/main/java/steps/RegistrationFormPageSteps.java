package steps;

import pageObjects.elementsPageObjects.RegistrationFormPage;

public class RegistrationFormPageSteps extends MainPageSteps {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    public void clickSubmitButton() {
        registrationFormPage.clickSubmitButton();
    }
}
