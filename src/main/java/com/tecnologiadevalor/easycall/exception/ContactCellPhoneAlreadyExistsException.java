package com.tecnologiadevalor.easycall.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContactCellPhoneAlreadyExistsException extends RuntimeException {

    private String title = "Cell Phone Already Exists";
    private String description = "It is not possible to register more than one cell phone per contact";

}
