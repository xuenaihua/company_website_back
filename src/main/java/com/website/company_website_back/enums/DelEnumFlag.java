package com.website.company_website_back.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DelEnumFlag {


    NORMAL(0,"正常"),


    DELETE(-1,"删除");


    private final Integer code;


    private final String message;
}
