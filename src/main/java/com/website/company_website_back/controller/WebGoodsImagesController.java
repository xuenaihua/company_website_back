package com.website.company_website_back.controller;

import com.website.company_website_back.entity.WebGoodsImages;
import com.website.company_website_back.service.IWebGoodsImagesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;

@RestController
@RequestMapping("/images")
public class WebGoodsImagesController {


    @Resource
    private IWebGoodsImagesService webGoodsImagesService;

    @PostMapping("/upload")
    public ResponseEntity<WebGoodsImages> uploadImage(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(webGoodsImagesService.uploadImage(file));
    }

    @GetMapping("/{token}")
    public ResponseEntity<org.springframework.core.io.Resource> getImageByToken(@PathVariable String token) {

        org.springframework.core.io.Resource resource = webGoodsImagesService.imageByToken(token);
        if (null==resource){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok()
                .header("Content-Type", "image/jpeg") // 根据实际文件类型动态设置
                .body(resource);
    }
}
