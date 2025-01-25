package com.website.company_website_back.entity;


import java.util.Date;


/**
 * 用户对象 sys_user
 * 
 * @author ruoyi
 */
public class SysUser
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;


    /** 用户账号 */

    private String userName;


    /** 手机号码 */

    private String phonenumber;


    /** 密码 */
    private String password;


    /** 删除标志（0代表存在 2代表删除） */

    private String delFlag;

    /** 最后登录IP */

    private String loginIp;

    /** 最后登录时间 */

    private Date loginDate;

}
