package com.website.company_website_back.uils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private Integer code;        // 状态码
    private String message;      // 提示消息
    private T data;              // 泛型数据（可以是任何类型，支持图片、JSON、对象等）

    // 用于构造成功响应
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "成功", data);
    }

    // 用于构造失败响应
    public static <T> ApiResponse<T> failure(Integer code, String message) {
        return new ApiResponse<>(code, message, null);
    }
}

