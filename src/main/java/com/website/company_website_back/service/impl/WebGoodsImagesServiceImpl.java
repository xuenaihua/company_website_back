package com.website.company_website_back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.website.company_website_back.entity.WebGoodsImages;
import com.website.company_website_back.enums.DelEnumFlag;
import com.website.company_website_back.mapper.WebGoodsImagesMapper;
import com.website.company_website_back.service.IWebGoodsImagesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
public class WebGoodsImagesServiceImpl extends ServiceImpl<WebGoodsImagesMapper, WebGoodsImages> implements IWebGoodsImagesService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    @Resource
    private WebGoodsImagesMapper webGoodsImagesMapper;

    @Override
    public WebGoodsImages uploadImage(MultipartFile file) {

        // 生成当前日期文件夹名称（例如：2025-01-19）
        String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Path dateFolderPath = Paths.get(uploadDir, currentDate);

        try {
            // 创建日期文件夹（如果不存在）
            if (!Files.exists(dateFolderPath)) {
                Files.createDirectories(dateFolderPath);
            }
        }catch (Exception e){
            log.error("创建文件夹失败：{}", e.getMessage());
            throw new RuntimeException("创建文件夹失败，请联系开发人员处理！");
        }


        // 获取文件名并生成唯一 Token
        String originalFilename = StringUtils.cleanPath(
                Objects.requireNonNull(
                        file.getOriginalFilename()
                )
        );
        String fileExtension = getFileExtension(originalFilename); // 获取文件后缀名
        String token = UUID.randomUUID().toString(); // 生成唯一 Token
        String newFilename = token + (fileExtension.isEmpty() ? "" : "." + fileExtension); // 新文件名

        // 保存文件到日期目录
        Path filePath = dateFolderPath.resolve(newFilename);
        try {
            Files.copy(file.getInputStream(), filePath);
        } catch (Exception e) {
            log.error("拷贝文件失败：{}", e.getMessage());
            throw new RuntimeException("拷贝文件失败，请联系开发人员处理！");
        }

        // 保存图片元数据到数据库
        WebGoodsImages image = new WebGoodsImages();
        image.setFileToken(token);
        image.setFileName(originalFilename);
        image.setFilePath(filePath.toString());
        image.setSize(file.getSize());
        image.setUploadDate(new Date());
        boolean saveFlag = this.save(image);
        if (!saveFlag){
            log.error("保存图片元数据到数据库失败,文件名：{}",originalFilename);
            throw new RuntimeException("保存图片元数据到数据库失败，请联系开发人员处理！");
        }
        return image;
    }

    @Override
    public org.springframework.core.io.Resource imageByToken(String token) {
        LambdaQueryWrapper<WebGoodsImages> imageWrapper = Wrappers.lambdaQuery(WebGoodsImages.class);
        imageWrapper.eq(WebGoodsImages::getFileToken,token)
                .eq(WebGoodsImages::getDeleteFlag, DelEnumFlag.NORMAL.getCode());

        WebGoodsImages image = this.getOne(imageWrapper);
        if (Objects.isNull(image)){
            return null;
        }

        Path filePath = Paths.get(image.getFilePath());
        org.springframework.core.io.Resource resource = new FileSystemResource(filePath.toFile());

        if (!resource.exists()) {
            return null;
        }
        return resource;
    }

    /**
     * 获取文件扩展名
     * @param filename 文件名
     * @return 结果
     */
    private String getFileExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        return (dotIndex == -1) ? "" : filename.substring(dotIndex + 1);
    }
}
