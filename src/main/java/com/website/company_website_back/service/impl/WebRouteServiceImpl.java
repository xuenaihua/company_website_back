package com.website.company_website_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.website.company_website_back.dto.WebRouteDto;
import com.website.company_website_back.entity.WebRoute;
import com.website.company_website_back.enums.DelEnumFlag;
import com.website.company_website_back.mapper.WebRouteMapper;
import com.website.company_website_back.service.IWebRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class WebRouteServiceImpl extends ServiceImpl<WebRouteMapper, WebRoute> implements IWebRouteService {

    @Resource
    private WebRouteMapper webRouteMapper;

    @Override
    public List<WebRoute> getRouteList(Integer routeType) {
        LambdaQueryWrapper<WebRoute> query = Wrappers.lambdaQuery();
        query.eq(WebRoute::getDeleteFlag, DelEnumFlag.NORMAL.getCode())
                .eq(WebRoute::getType, routeType)
                .orderByAsc(WebRoute::getSort);
        return this.list(query);
    }

    @Override
    public Boolean updateRouteById(WebRouteDto webRouteDto) {
        LambdaUpdateWrapper<WebRoute> update = Wrappers.lambdaUpdate(WebRoute.class);
        update.eq(WebRoute::getId, webRouteDto.getId())
                .eq(WebRoute::getDeleteFlag, DelEnumFlag.NORMAL.getCode())
                .set(WebRoute::getName, webRouteDto.getName())
                .set(WebRoute::getSort, webRouteDto.getSort())
                .set(WebRoute::getUpdateDate, new Date());
        return this.update(update);
    }

    @Override
    public Boolean saveRoute(WebRouteDto webRouteDto) {
        WebRoute webRoute = new WebRoute();
        webRoute.setName(webRouteDto.getName());
        webRoute.setSort(webRouteDto.getSort());
        return this.save(webRoute);
    }
}
