package tests;

import fields.*;
import selenium.SeleniumMethods;
import steps.*;

public class BaseTest {

    protected MainPageSteps mainPageSteps = new MainPageSteps();
    protected ToolsQAPageSteps toolsQAPageSteps = new ToolsQAPageSteps();
    protected TextBoxPageSteps textBoxPageSteps = new TextBoxPageSteps();
    protected RegistrationFormPageSteps registrationFormPageSteps = new RegistrationFormPageSteps();
    protected WebTablesPageSteps webTablesPageSteps = new WebTablesPageSteps();
    protected UploadDownloadPageSteps uploadDownloadPageSteps = new UploadDownloadPageSteps();
    protected AlertsPageSteps alertsPageSteps = new AlertsPageSteps();

    protected IFields radioButtonField = new RadioButtonField();
    protected IFields textField = new TextField();
    protected IFields textAreaField = new TextAreaField();
    protected IFields linkField = new LinkField();

    protected SeleniumMethods seleniumMethods = new SeleniumMethods();
}
