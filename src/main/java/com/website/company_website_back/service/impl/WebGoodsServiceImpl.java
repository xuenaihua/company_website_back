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
import com.website.company_website_back.service.IWebGoodsImagesService;
import com.website.company_website_back.service.IWebGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class WebGoodsServiceImpl extends ServiceImpl<WebGoodsMapper, WebGoods> implements IWebGoodsService {

    @Resource
    private WebGoodsMapper webGoodsMapper;

    @Resource
    private IWebGoodsImagesService webGoodsImagesService;

    @Override
    public Page<WebGoods> getGoodsList(WebGoodsQueryDto webGoodsQueryDto) {
        return webGoodsMapper.selectGoodsList(
                new Page<>(webGoodsQueryDto.getPageNo(), webGoodsQueryDto.getPageSize()),
                webGoodsQueryDto
        );
    }

    @Override
    @Transactional
    public Boolean updateGoodsById(WebGoodsDto webGoodsDto) {
        LambdaUpdateWrapper<WebGoods> updateWrapper = Wrappers.lambdaUpdate(WebGoods.class);
        updateWrapper.eq(WebGoods::getId, webGoodsDto.getId())
                .eq(WebGoods::getDeleteFlag, DelEnumFlag.NORMAL.getCode())
                .set(WebGoods::getRouteId, webGoodsDto.getRouteId())
                .set(WebGoods::getName, webGoodsDto.getName())
                .set(WebGoods::getPrice, webGoodsDto.getPrice())
                .set(WebGoods::getUnit, webGoodsDto.getUnit())
                .set(WebGoods::getSort, webGoodsDto.getSort())
                .set(WebGoods::getUpdateDate, new Date());
        boolean update = this.update(updateWrapper);
        Boolean imagesFlag = webGoodsImagesService.saveOrDel(webGoodsDto.getId(), webGoodsDto.getImages());
        return update&&imagesFlag;
    }

    @Override
    @Transactional
    public Boolean addGoods(WebGoodsDto webGoodsDto) {
        WebGoods webGoods = new WebGoods();
        webGoods.setRouteId(webGoodsDto.getRouteId());
        webGoods.setName(webGoodsDto.getName());
        webGoods.setPrice(webGoodsDto.getPrice());
        webGoods.setUnit(webGoodsDto.getUnit());
        webGoods.setSort(webGoodsDto.getSort());
        boolean saveFlag = this.save(webGoods);
        Boolean imagesFlag = webGoodsImagesService.saveOrDel(webGoods.getId(), webGoodsDto.getImages());
        return saveFlag&&imagesFlag;
    }
}
