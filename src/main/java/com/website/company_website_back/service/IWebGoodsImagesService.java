package com.website.company_website_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.website.company_website_back.entity.WebGoodsImages;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface IWebGoodsImagesService extends IService<WebGoodsImages> {

    WebGoodsImages uploadImage(MultipartFile file);


    Resource imageByToken(String token);
}
