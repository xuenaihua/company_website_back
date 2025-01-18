package com.website.company_website_back.dto;

import com.website.company_website_back.uils.SortField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "商品查询参数")
@AllArgsConstructor
@NoArgsConstructor
public class WebGoodsQueryDto {

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "路由（分类）信息")
    @NotNull(message = "路由（分类）信息不能为空")
    private Long routeId;

    @ApiModelProperty(value = "页码")
    @NotNull(message = "页码不能为空")
    private int pageNo;

    @ApiModelProperty(value = "每页条数")
    @NotNull(message = "每页条数不能为空")
    private int pageSize;

    private List<SortField> sortFields;
}
