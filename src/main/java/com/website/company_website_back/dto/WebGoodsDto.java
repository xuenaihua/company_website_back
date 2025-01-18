package com.website.company_website_back.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.website.company_website_back.annotation.PostGroup;
import com.website.company_website_back.annotation.PutGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ApiModel(value = "商品传入参数")
@AllArgsConstructor
@NoArgsConstructor
public class WebGoodsDto {

    /**
     * ID
     */
    @ApiModelProperty(value = "商品ID",required = true)
    @NotNull(groups = {PutGroup.class},message = "商品ID不能为空")
    private Long id;

    /**
     * 分类路由ID
     */
    @ApiModelProperty(value = "路由（分类）信息",required = true)
    @NotNull(groups = {PutGroup.class, PostGroup.class},message = "路由（分类）信息不能为空")
    private Long routeId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称",required = true)
    @NotEmpty(message = "名称不能为空")
    private String name;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格",required = true)
    @NotNull(groups = {PutGroup.class, PostGroup.class},message = "价格不能为空")
    private Double price;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    @NotEmpty(message = "单位不能为空")
    private String unit;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    @JsonProperty(defaultValue = "0")
    private Integer sort;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片")
    private MultipartFile[] goodsImages;
}
