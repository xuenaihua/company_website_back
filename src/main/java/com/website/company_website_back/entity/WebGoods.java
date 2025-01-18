package com.website.company_website_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@ApiModel(value = "商品实体类")
@AllArgsConstructor
@NoArgsConstructor
public class WebGoods {

    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 分类路由ID
     */
    @ApiModelProperty(value = "分类路由ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long routeId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private Double price;

    /**
     * 单位
     */
    @ApiModelProperty(value = "单位")
    private String unit;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 删除标识
     */
    @ApiModelProperty(value = "删除标识")
    @TableLogic(value = "0",delval = "-1")
    private Integer deleteFlag;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateDate;
}
