package com.website.company_website_back.dto;

import com.website.company_website_back.uils.SortField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebGoodsQueryDto {

    private String name;

    @NotNull(message = "路由（分类）信息不能为空")
    private Long routeId;

    @NotNull(message = "页码不能为空")
    private int pageNo;

    @NotNull(message = "每页条数不能为空")
    private int pageSize;

    private List<SortField> sortFields;
}
