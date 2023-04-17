package steps;

import pageObjects.ToolsQAPage;

public class ToolsQAPageSteps extends MainPageSteps {

    ToolsQAPage toolsQAPage = new ToolsQAPage();

    public void openMainPage(String testUrl) {
        toolsQAPage.openMainPage(testUrl);
    }

    public void goToSection(String sectionName){
        toolsQAPage.goToSection(sectionName);
    }

    public void goToInnerSection(String sectionName){
        toolsQAPage.goToInnerSection(sectionName);
    }
}
