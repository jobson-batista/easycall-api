package com.tecnologiadevalor.easycall.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContactEmailAlreadyExistsException extends RuntimeException {

    private String title = "Email Already Exists";
    private String description = "It is not possible to register more than one email per contact";

}
