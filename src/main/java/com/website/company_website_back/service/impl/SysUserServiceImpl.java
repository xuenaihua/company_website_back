package com.website.company_website_back.service.impl;


import com.website.company_website_back.constant.UserConstants;
import com.website.company_website_back.entity.SysUser;
import com.website.company_website_back.mapper.SysUserMapper;
import com.website.company_website_back.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.annotation.Resource;
import javax.validation.Validator;


/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysUserServiceImpl implements ISysUserService
{
    private static final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Resource
    private SysUserMapper userMapper;


    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByUserName(String userName)
    {
        return userMapper.selectUserByUserName(userName);
    }

    /**
     * 通过用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long userId)
    {
        return userMapper.selectUserById(userId);
    }



    /**
     * 校验用户名称是否唯一
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public boolean checkUserNameUnique(SysUser user)
    {
//        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
//        SysUser info = userMapper.checkUserNameUnique(user.getUserName());
//        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
//        {
//            return UserConstants.NOT_UNIQUE;
//        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public boolean checkPhoneUnique(SysUser user)
    {
//        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
//        SysUser info = userMapper.checkPhoneUnique(user.getPhonenumber());
//        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
//        {
//            return UserConstants.NOT_UNIQUE;
//        }
        return UserConstants.UNIQUE;
    }

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public boolean checkEmailUnique(SysUser user)
    {
//        Long userId = StringUtils.isNull(user.getUserId()) ? -1L : user.getUserId();
//        SysUser info = userMapper.checkEmailUnique(user.getEmail());
//        if (StringUtils.isNotNull(info) && info.getUserId().longValue() != userId.longValue())
//        {
//            return UserConstants.NOT_UNIQUE;
//        }
        return UserConstants.UNIQUE;
    }









    /**
     * 修改用户基本信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int updateUserProfile(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 修改用户头像
     * 
     * @param userName 用户名
     * @param avatar 头像地址
     * @return 结果
     */
    @Override
    public boolean updateUserAvatar(String userName, String avatar)
    {
        return userMapper.updateUserAvatar(userName, avatar) > 0;
    }

    /**
     * 重置用户密码
     * 
     * @param user 用户信息
     * @return 结果
     */
    @Override
    public int resetPwd(SysUser user)
    {
        return userMapper.updateUser(user);
    }

    /**
     * 重置用户密码
     * 
     * @param userName 用户名
     * @param password 密码
     * @return 结果
     */
    @Override
    public int resetUserPwd(String userName, String password)
    {
        return userMapper.resetUserPwd(userName, password);
    }



    /**
     * 通过用户ID删除用户
     * 
     * @param userId 用户ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteUserById(Long userId)
    {

        return userMapper.deleteUserById(userId);
    }


}
