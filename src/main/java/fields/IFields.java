package fields;

import selenium.SeleniumMethods;

import java.util.List;

public interface IFields {

    SeleniumMethods setFieldValue(String fieldName, String[] values) throws Exception;

    String getFieldValue(String fieldName);


}
