package com.website.company_website_back.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "商品图片关系对象")
public class WebGoodsImages {

    @ApiModelProperty(value = "商品id")
    private Long goodsId;

    @ApiModelProperty(value = "图片id")
    private Long imageId;

    @ApiModelProperty(value = "删除标志")
    @JsonIgnore
    @TableLogic(value = "0",delval = "-1")
    private Integer deleteFlag;
}
