package com.website.company_website_back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.website.company_website_back.entity.WebImages;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface IWebImagesService extends IService<WebImages> {

    WebImages uploadImage(MultipartFile file);


    Resource imageByToken(String token);
}
