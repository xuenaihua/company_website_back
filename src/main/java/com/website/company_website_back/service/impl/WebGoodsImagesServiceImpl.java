package com.website.company_website_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.website.company_website_back.entity.WebGoodsImages;
import com.website.company_website_back.enums.DelEnumFlag;
import com.website.company_website_back.mapper.WebGoodsImagesMapper;
import com.website.company_website_back.service.IWebGoodsImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WebGoodsImagesServiceImpl extends ServiceImpl<WebGoodsImagesMapper, WebGoodsImages> implements IWebGoodsImagesService {

    @Override
    @Transactional
    public Boolean saveOrDel(Long goodsId, List<String> images) {
        if (CollectionUtils.isEmpty(images)){
            return true;
        }
        if (goodsId == null){
            return true;
        }

        //根据商品ID 查询所有的图片
        List<WebGoodsImages> webGoodsImages = this.getImagesByGoodsId(goodsId);

        List<String> imageList = webGoodsImages
                .stream()
                .map(WebGoodsImages::getImageId)
                .map(String::valueOf)
                .collect(Collectors.toList());

        // 新增的部分
        List<String> newAdd = new ArrayList<>(images);
        newAdd.removeAll(imageList); // B - A

        // 需要删除的部分
        List<String> del = new ArrayList<>(imageList);
        del.removeAll(images); // A - B

        if (!CollectionUtils.isEmpty(del)){
            this.removeByIds(del);
        }

        ArrayList<WebGoodsImages> tempList = new ArrayList<>();
        for (String image : newAdd) {
            WebGoodsImages obj = new WebGoodsImages(goodsId, Long.valueOf(image), DelEnumFlag.NORMAL.getCode());
            tempList.add(obj);
        }
        return this.saveBatch(tempList);
    }

    @Override
    public List<WebGoodsImages> getImagesByGoodsId(Long goodsId) {
        if (Objects.isNull(goodsId)){
            return Collections.emptyList();
        }
        LambdaQueryWrapper<WebGoodsImages> query = Wrappers.lambdaQuery(WebGoodsImages.class);
        query.eq(WebGoodsImages::getGoodsId,goodsId.toString())
                .eq(WebGoodsImages::getDeleteFlag, DelEnumFlag.NORMAL.getCode());
        return this.list(query);
    }
}
