package com.website.company_website_back.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.website.company_website_back.annotation.PutGroup;
import com.website.company_website_back.dto.WebGoodsDto;
import com.website.company_website_back.dto.WebGoodsQueryDto;
import com.website.company_website_back.entity.WebGoods;
import com.website.company_website_back.service.IWebGoodsService;
import com.website.company_website_back.uils.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "商品")
@RestController
@RequestMapping("/goods")
public class WebGoodsController {

    @Resource
    private IWebGoodsService webGoodsService;

    @ApiOperation(value = "查询商品分页")
    @PostMapping("/page")
    public ApiResponse<Page<WebGoods>> getGoodsList(
            @RequestBody @Validated WebGoodsQueryDto webGoodsQueryDto
    ){
        return ApiResponse.success(webGoodsService.getGoodsList(webGoodsQueryDto));
    }

    @ApiOperation(value = "查询商品详情")
    @GetMapping("/{id}")
    public ApiResponse<WebGoods> getGoodsById(
            @PathVariable Long id
    ){
        return ApiResponse.success(webGoodsService.getById(id));
    }

    @ApiOperation(value = "修改商品")
    @PutMapping
    public ApiResponse<Boolean> updateGoodsById(
            @RequestBody @Validated(value = {PutGroup.class}) WebGoodsDto webGoodsDto
    ){
        return ApiResponse.success(webGoodsService.updateGoodsById(webGoodsDto));
    }

    @ApiOperation(value = "添加商品")
    @PostMapping
    public ApiResponse<Boolean> addGoods(
            @RequestBody @Validated WebGoodsDto webGoodsDto
    ){
        return ApiResponse.success(webGoodsService.addGoods(webGoodsDto));
    }

    @ApiOperation(value = "删除商品")
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteGoodsById(
            @PathVariable Long id
    ){
        return ApiResponse.success(webGoodsService.removeById(id));
    }
}
