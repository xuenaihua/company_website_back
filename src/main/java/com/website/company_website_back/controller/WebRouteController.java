package com.website.company_website_back.controller;

import com.website.company_website_back.annotation.PostGroup;
import com.website.company_website_back.annotation.PutGroup;
import com.website.company_website_back.dto.WebRouteDto;
import com.website.company_website_back.entity.WebRoute;
import com.website.company_website_back.service.IWebRouteService;
import com.website.company_website_back.uils.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "分类路由")
@RestController
@RequestMapping("/route")
public class WebRouteController {

    @Resource
    private IWebRouteService webRouteService;

    @ApiOperation(value = "查询分类路由")
    @GetMapping("/{routeType}")
    public ApiResponse<List<WebRoute>> getRouteList(@PathVariable(value = "routeType") Integer routeType){
        return ApiResponse.success(webRouteService.getRouteList(routeType));
    }

    @ApiOperation(value = "修改分类路由")
    @PutMapping
    public ApiResponse<Boolean> updateRouteById(
            @RequestBody @Validated(value = {PutGroup.class}) WebRouteDto webRouteDto
            ){
        return ApiResponse.success(webRouteService.updateRouteById(webRouteDto));
    }

    @ApiOperation(value = "添加分类路由")
    @PostMapping
    public ApiResponse<Boolean> addRoute(
            @RequestBody @Validated(value = {PostGroup.class}) WebRouteDto webRouteDto
    ){
        return ApiResponse.success(webRouteService.saveRoute(webRouteDto));
    }

    @ApiOperation(value = "删除分类路由")
    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteRouteList(
            @PathVariable Long id
    ){
        return ApiResponse.success(webRouteService.removeById(id));
    }
}
