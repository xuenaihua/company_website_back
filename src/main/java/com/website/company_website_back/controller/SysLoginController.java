package com.website.company_website_back.controller;


import com.website.company_website_back.constant.Constants;
import com.website.company_website_back.entity.SysUser;
import com.website.company_website_back.model.LoginBody;
import com.website.company_website_back.model.LoginUser;
import com.website.company_website_back.service.function.SysLoginService;
import com.website.company_website_back.service.function.TokenService;
import com.website.company_website_back.uils.AjaxResult;
import com.website.company_website_back.uils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



/**
 * 登录验证
 * 
 * @author ruoyi
 */
@RestController
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody)
    {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo()
    {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();

//        if (!loginUser.getPermissions().equals(permissions))
//        {
//            loginUser.setPermissions(permissions);
            tokenService.refreshToken(loginUser);
//        }
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);

        return ajax;
    }
}
