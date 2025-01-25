package com.website.company_website_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.website.company_website_back.dto.WebRouteDto;
import com.website.company_website_back.entity.WebRoute;

import java.util.List;

public interface IWebRouteService extends IService<WebRoute> {

    /**
     * 获取路由列表
     * @return 列表
     */
    List<WebRoute> getRouteList(Integer routeType);

    /**
     * 更新路由
     * @param webRouteDto 路由
     * @return 是否成功
     */
    Boolean updateRouteById(WebRouteDto webRouteDto);

    /**
     * 新增路由
     * @param webRouteDto 路由
     * @return 是否成功
     */
    Boolean saveRoute(WebRouteDto webRouteDto);

}
