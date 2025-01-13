package com.website.company_website_back.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.website.company_website_back.annotation.PutGroup;
import com.website.company_website_back.dto.WebGoodsDto;
import com.website.company_website_back.dto.WebGoodsQueryDto;
import com.website.company_website_back.entity.WebGoods;
import com.website.company_website_back.service.IWebGoodsService;
import com.website.company_website_back.uils.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/goods")
public class WebGoodsController {

    @Resource
    private IWebGoodsService webGoodsService;

    @PostMapping("/page")
    public ApiResponse<Page<WebGoods>> getGoodsList(
            @RequestBody @Validated WebGoodsQueryDto webGoodsQueryDto
    ){
        return ApiResponse.success(webGoodsService.getGoodsList(webGoodsQueryDto));
    }

    @GetMapping("/{id}")
    public ApiResponse<WebGoods> getGoodsById(
            @PathVariable Long id
    ){
        return ApiResponse.success(webGoodsService.getById(id));
    }

    @PutMapping
    public ApiResponse<Boolean> updateGoodsById(
            @RequestBody @Validated(value = {PutGroup.class}) WebGoodsDto webGoodsDto
    ){
        return ApiResponse.success(webGoodsService.updateGoodsById(webGoodsDto));
    }

    @PostMapping
    public ApiResponse<Boolean> addGoods(
            @RequestBody @Validated WebGoodsDto webGoodsDto
    ){
        return ApiResponse.success(webGoodsService.addGoods(webGoodsDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteGoodsById(
            @PathVariable Long id
    ){
        return ApiResponse.success(webGoodsService.removeById(id));
    }


}
