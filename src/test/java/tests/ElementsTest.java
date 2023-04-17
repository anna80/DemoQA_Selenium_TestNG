package tests;

import dto.TextBoxTable;
import dto.WebTables;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static utils.DriverManager.closeDriver;

public class ElementsTest extends BaseTest {

    @Parameters({"browser", "testUrl"})
    @BeforeClass
    public void setUpOne(String browser, String testUrl) {
        toolsQAPageSteps.openMainPage(testUrl);
        toolsQAPageSteps.goToSection("Elements");
    }

    @Test(priority = 1)
    public void testTextBox1() throws Exception {
        mainPageSteps.goToPage("Text Box");
        seleniumMethods.setFieldValue(textField, "Full Name", new String[]{"Anna Holubenko"})
                .setFieldValue(textField, "Email", new String[]{"anuli4ka@gmail.com"})
                .setFieldValue(textAreaField, "Current Address", new String[]{"Vinnitsa"})
                .setFieldValue(textAreaField, "Permanent Address", new String[]{"Vinnitsa"});
        textBoxPageSteps.clickSubmitButton();

        TextBoxTable expectedTextBoxTable = new TextBoxTable()
                .setFullName("Anna Holubenko")
                .setEmail("anuli4ka@gmail.com")
                .setCurrentAddress("Vinnitsa")
                .setPermanentAddress("Vinnitsa");

        TextBoxTable actualTextBoxTable = new TextBoxTable()
                .setFullName(seleniumMethods.getTextFromTextBoxTableByXpath("name"))
                .setEmail(seleniumMethods.getTextFromTextBoxTableByXpath("email"))
                .setCurrentAddress(seleniumMethods.getTextFromTextBoxTableByXpath("currentAddress"))
                .setPermanentAddress(seleniumMethods.getTextFromTextBoxTableByXpath("permanentAddress"));

        assertEquals(expectedTextBoxTable, actualTextBoxTable);
    }

    @Test(priority = 2)
    public void testUploadDownload() {
        mainPageSteps.goToPage("Upload and Download");
        uploadDownloadPageSteps.clickChooseFile();
    }

    @Test(priority = 3)
    public void TestTextBox2() throws Exception {
        mainPageSteps.goToPage("Text Box");
        seleniumMethods.setFieldValue(textField, "Full Name", new String[]{"Anna Holubenko"});
        textBoxPageSteps.clickSubmitButton();

        TextBoxTable expectedTextBoxTable = new TextBoxTable()
                .setFullName("Anna Holubenko")
                .setEmail(null)
                .setCurrentAddress(null)
                .setPermanentAddress(null);
        TextBoxTable actualTextBoxTable = new TextBoxTable()
                .setFullName(seleniumMethods.getTextFromTextBoxTableByXpath("name"))
                .setEmail(seleniumMethods.getTextFromTextBoxTableByXpath("email"))
                .setCurrentAddress(seleniumMethods.getTextFromTextBoxTableByXpath("currentAddress"))
                .setPermanentAddress(seleniumMethods.getTextFromTextBoxTableByXpath("permanentAddress"));
        assertEquals(expectedTextBoxTable, actualTextBoxTable);
    }

    @Test(priority = 4)
    public void testWebTables() throws Exception {
        mainPageSteps.goToPage("Web Tables");
        webTablesPageSteps.clickAddButton();
        seleniumMethods.setFieldValue(textField, "First Name", new String[]{"Bob"})
                .setFieldValue(textField, "Last Name", new String[]{"Anderson"})
                .setFieldValue(textField, "Email", new String[]{"anderson@gmail.com"})
                .setFieldValue(textField, "Age", new String[]{"25"})
                .setFieldValue(textField, "Salary", new String[]{"25000"})
                .setFieldValue(textField, "Department", new String[]{"Taxes"});
        registrationFormPageSteps.clickSubmitButton();
        webTablesPageSteps.clickDeleteButton();

        WebTables expectedWebTables = new WebTables()
                .setFirstName("Cierra")
                .setLastName("Vega")
                .setAge("39")
                .setEmail("cierra@example.com")
                .setSalary("10000")
                .setDepartment("Insurance");
        List<String> actWebTables = seleniumMethods.getTextFromWebTableByXpath("1");
        WebTables actualWebTables = new WebTables()
                .setFirstName(actWebTables.get(0))
                .setLastName(actWebTables.get(1))
                .setAge(actWebTables.get(2))
                .setEmail(actWebTables.get(3))
                .setSalary(actWebTables.get(4))
                .setDepartment(actWebTables.get(5));
        assertEquals(expectedWebTables, actualWebTables);

        List<String> expWebTables = Arrays.asList("Cierra", "Vega", "39", "cierra@example.com", "10000", "Insurance");
        assertEquals(expWebTables, actWebTables);
    }

    @Test(priority = 5)
    public void testRadioButtons() throws Exception {
        mainPageSteps.goToPage("Radio Button");
        seleniumMethods.setFieldValue(radioButtonField, "Do you like the site?", new String[]{"Impressive"});
    }

    @Test(priority = 6)
    public void testLinks() {
        mainPageSteps.goToPage("Links");
        assertEquals(seleniumMethods.getFieldValue(linkField, "Created"), "javascript:void(0)");
        mainPageSteps.clickOnLink("Created");
    }

    @Test(priority = 7)
    public void testLinks1() {
        mainPageSteps.goToPage("Links");
        assertEquals(seleniumMethods.getFieldValue(linkField, "Home"), "https://demoqa.com/");
        mainPageSteps.clickOnLink("Home");
    }

    @AfterClass
    public void shutDown() {
        closeDriver();
    }
}
