package fields;

public class TextAreaField extends TextField {

    private static final String TEXT_AREA_XPATH = "//label[text()='%s']/..//following-sibling::div/textarea";

    @Override
    protected String getXpath() {
        return TEXT_AREA_XPATH;
    }
}
