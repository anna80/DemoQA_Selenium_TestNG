package dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
public class WebTables {

    private String firstName;
    private String lastName;
    private String age;
    private String email;
    private String salary;
    private String department;
//    private int rowNumber;
}
