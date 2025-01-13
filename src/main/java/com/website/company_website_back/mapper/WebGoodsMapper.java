package com.website.company_website_back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.website.company_website_back.dto.WebGoodsQueryDto;
import com.website.company_website_back.entity.WebGoods;
import org.apache.ibatis.annotations.Param;

public interface WebGoodsMapper extends BaseMapper<WebGoods> {

    /**
     * 分页查询商品列表
     *
     * @param page 分页对象
     * @param webGoodsQueryDto 参数
     * @return 结果
     */
    Page<WebGoods> selectGoodsList(
            Page<WebGoods> page,
            @Param("webGoodsDto") WebGoodsQueryDto webGoodsQueryDto
    );

}
