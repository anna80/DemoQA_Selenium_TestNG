package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertEquals;
import static utils.DriverManager.closeDriver;

public class AlertFrameWindowsTest extends BaseTest{

    @Parameters({"browser", "testUrl"})
    @BeforeClass
    public void setUpOne(String browser, String testUrl) {
        toolsQAPageSteps.openMainPage(testUrl);
        toolsQAPageSteps.goToSection("Alerts, Frame & Windows");
    }

    @Test(priority = 1)
    public void testFrame() {
        mainPageSteps.goToPage("Frames");
        mainPageSteps.switchToFirstIframe();
        assertEquals("This is a sample page", mainPageSteps.getFieldValue());
        mainPageSteps.switchToDefaultContent();
        assertEquals("Frames", mainPageSteps.getPageTitle("Frames"));
        mainPageSteps.switchToSecondIframe();
        assertEquals("This is a sample page", mainPageSteps.getFieldValue());
        mainPageSteps.switchToDefaultContent();
        assertEquals("Frames", mainPageSteps.getPageTitle("Frames"));
    }

    @Test(priority = 2)
    public void testAlert() {
        mainPageSteps.goToPage("Alerts");
        alertsPageSteps.clickOnAlertButton();
        alertsPageSteps.PopupWindowAlert();
    }

    @Test(priority = 3)
    public void testTimeAlert() {
        mainPageSteps.goToPage("Alerts");
        alertsPageSteps.clickOnTimeAlertButton();
        alertsPageSteps.PopupWindowAlert();
    }

    @Test(priority = 4)
    public void testConfirmAlert() {
        mainPageSteps.goToPage("Alerts");
        alertsPageSteps.clickOnConfirmAlertButton();
        alertsPageSteps.PopupWindowAlert();
        assertEquals("You selected Ok", alertsPageSteps.getAlertText("You selected OK"));
    }

    @Test(priority = 5)
    public void testPromtAlert() {
        mainPageSteps.goToPage("Alerts");
        alertsPageSteps.clickOnPromtAlertButton();
        alertsPageSteps.PopupWindowAlert();
        assertEquals("You entered Text", alertsPageSteps.getPromtAlertText("You entered text"));
    }

    @AfterClass
    public void shutDown() {
        closeDriver();
    }

}
