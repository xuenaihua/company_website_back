package com.website.company_website_back.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebGoodsImages {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 文件token
     */
    private String fileToken;

    /**
     * 文件path
     */
    private String filePath;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 删除标识
     */
    @TableLogic(value = "0",delval = "-1")
    private Integer deleteFlag;

    /**
     * 上传时间
     */
    private Date uploadDate;
}
