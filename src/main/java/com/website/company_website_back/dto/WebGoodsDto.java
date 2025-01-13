package com.website.company_website_back.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.website.company_website_back.annotation.PostGroup;
import com.website.company_website_back.annotation.PutGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebGoodsDto {

    /**
     * ID
     */
    @NotNull(groups = {PutGroup.class},message = "商品ID不能为空")
    private Long id;

    /**
     * 分类路由ID
     */
    @NotNull(groups = {PutGroup.class, PostGroup.class},message = "路由（分类）信息不能为空")
    private Long routeId;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    @NotNull(groups = {PutGroup.class, PostGroup.class},message = "价格不能为空")
    private Double price;

    /**
     * 单位
     */
    @NotEmpty(message = "单位不能为空")
    private String unit;

    /**
     * 排序
     */
    @JsonProperty(defaultValue = "0")
    private Integer sort;

    /**
     * 商品图片
     */
    private MultipartFile[] goodsImages;
}
