package com.website.company_website_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.website.company_website_back.entity.WebGoodsImages;

import java.util.List;

public interface IWebGoodsImagesService extends IService<WebGoodsImages> {

    /**
     * 根据商品id保存或删除商品图片
     * @param goodsId 商品ID
     * @param images 图片列表
     * @return 结果
     */
    Boolean saveOrDel(Long goodsId, List<String> images);

    /**
     * 根据商品id获取商品图片列表
     * @param goodsId 商品ID
     * @return 图片列表
     */
    List<WebGoodsImages> getImagesByGoodsId(Long goodsId);
}
