package com.website.company_website_back.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.website.company_website_back.dto.WebGoodsDto;
import com.website.company_website_back.dto.WebGoodsQueryDto;
import com.website.company_website_back.entity.WebGoods;

public interface IWebGoodsService extends IService<WebGoods> {
    /**
     * 获取商品列表
     * @param webGoodsQueryDto 条件参数
     * @return 结果
     */
    Page<WebGoods> getGoodsList(WebGoodsQueryDto webGoodsQueryDto);

    /**
     * 更新商品
     * @param webGoodsDto 商品信息
     * @return 结果
     */
    Boolean updateGoodsById(WebGoodsDto webGoodsDto);

    /**
     * 添加商品
     * @param webGoodsDto 商品信息
     * @return 结果
     */
    Boolean addGoods(WebGoodsDto webGoodsDto);
}
