package com.website.company_website_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.website.company_website_back.dto.WebGoodsDto;
import com.website.company_website_back.dto.WebGoodsQueryDto;
import com.website.company_website_back.entity.WebGoods;
import com.website.company_website_back.enums.DelEnumFlag;
import com.website.company_website_back.mapper.WebGoodsMapper;
import com.website.company_website_back.service.IWebGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class WebGoodsServiceImpl extends ServiceImpl<WebGoodsMapper, WebGoods> implements IWebGoodsService {

    @Resource
    private WebGoodsMapper webGoodsMapper;

    @Override
    public Page<WebGoods> getGoodsList(WebGoodsQueryDto webGoodsQueryDto) {
        return webGoodsMapper.selectGoodsList(
                new Page<>(webGoodsQueryDto.getPageNo(), webGoodsQueryDto.getPageSize()),
                webGoodsQueryDto
        );
    }

    @Override
    public Boolean updateGoodsById(WebGoodsDto webGoodsDto) {
        LambdaUpdateWrapper<WebGoods> update = Wrappers.lambdaUpdate(WebGoods.class);
        update.eq(WebGoods::getId, webGoodsDto.getId())
                .eq(WebGoods::getDeleteFlag, DelEnumFlag.NORMAL.getCode())
                .set(WebGoods::getRouteId, webGoodsDto.getRouteId())
                .set(WebGoods::getName, webGoodsDto.getName())
                .set(WebGoods::getPrice, webGoodsDto.getPrice())
                .set(WebGoods::getUnit, webGoodsDto.getUnit())
                .set(WebGoods::getSort, webGoodsDto.getSort())
                .set(WebGoods::getUpdateDate, new Date());
        return this.update(update);
    }

    @Override
    public Boolean addGoods(WebGoodsDto webGoodsDto) {
        WebGoods webGoods = new WebGoods();
        webGoods.setRouteId(webGoodsDto.getRouteId());
        webGoods.setName(webGoodsDto.getName());
        webGoods.setPrice(webGoodsDto.getPrice());
        webGoods.setUnit(webGoodsDto.getUnit());
        webGoods.setSort(webGoodsDto.getSort());
        return this.save(webGoods);
    }
}
