package com.website.company_website_back.controller;

import com.website.company_website_back.annotation.PostGroup;
import com.website.company_website_back.annotation.PutGroup;
import com.website.company_website_back.dto.WebRouteDto;
import com.website.company_website_back.entity.WebRoute;
import com.website.company_website_back.service.IWebRouteService;
import com.website.company_website_back.uils.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/route")
public class WebRouteController {

    @Resource
    private IWebRouteService webRouteService;

    @GetMapping
    public ApiResponse<List<WebRoute>> getRouteList(){
        return ApiResponse.success(webRouteService.getRouteList());
    }

    @PutMapping
    public ApiResponse<Boolean> updateRouteById(
            @RequestBody @Validated(value = {PutGroup.class}) WebRouteDto webRouteDto
            ){
        return ApiResponse.success(webRouteService.updateRouteById(webRouteDto));
    }

    @PostMapping
    public ApiResponse<Boolean> addRoute(
            @RequestBody @Validated(value = {PostGroup.class}) WebRouteDto webRouteDto
    ){
        return ApiResponse.success(webRouteService.saveRoute(webRouteDto));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteRouteList(
            @PathVariable Long id
    ){
        return ApiResponse.success(webRouteService.removeById(id));
    }

}
