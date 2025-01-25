package com.website.company_website_back.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RouteTypeEnum {

    /**
     * 零售
     */
    RETAIL(1, "零售"),

    /**
     * 批发
     */
    WHOLESALE(2, "批发"),
    ;

    /**
     * 编码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;
}
