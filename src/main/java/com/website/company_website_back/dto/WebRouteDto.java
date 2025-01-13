package com.website.company_website_back.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.website.company_website_back.annotation.PostGroup;
import com.website.company_website_back.annotation.PutGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebRouteDto {
    /**
     * 主键
     */
    @NotNull(groups = {PutGroup.class},message = "路由ID不能为空")
    private Long id;

    /**
     * 路由名称
     */
    @NotNull(groups = {PutGroup.class, PostGroup.class},message = "路由名称不能为空")
    private String name;

    /**
     * 路由顺序
     */
    @JsonProperty(defaultValue = "0")
    private Integer sort;
}
