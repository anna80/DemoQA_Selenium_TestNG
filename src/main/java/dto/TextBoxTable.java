package dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TextBoxTable {

    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

}
