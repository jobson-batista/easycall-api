package com.tecnologiadevalor.easycall.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BadRequestException extends RuntimeException {

    private String title;
    private String description;

}
