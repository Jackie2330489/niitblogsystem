package com.niitblogsystem.service.impl;

import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.UserPojoMapper;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IUserService;
import com.niitblogsystem.util.EmailHelper;
import com.niitblogsystem.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * Created by Justin on 2017/9/12.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserPojoMapper userPojoMapper;

    @Override
    public ServerResponse<UserPojo> login(String username, String password) {
        //检查用户名是否存在
        int resultCount = userPojoMapper.checkUsername(username);
        if(resultCount == 0 ){
            //若不存在
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        //用户存在 把密码加密
        String md5Password=MD5Util.MD5EncodeUtf8(password);
        //根据用户名和密码搜数据库
        UserPojo userPojo=userPojoMapper.selectLogin(username,md5Password);
        if(userPojo==null){
            //若为空 则密码错误
            return ServerResponse.createByErrorMessage("密码错误");
        }
        //密码正确 把userPojo的密码设为空 ps:因为userPojo要添加到session中
        userPojo.setPassword(StringUtils.EMPTY);
        //返回登录成功
        return ServerResponse.createBySuccess("登录成功",userPojo);
    }

    public ServerResponse<String> register(UserPojo userPojo){
        //检查用户名是否存在
        ServerResponse validResponse=this.checkValid(userPojo.getUsername(),Const.USERNAME);
        if(!validResponse.isSuccess()){
            //若存在 返回 isSuccess表示不存在
            return validResponse;
        }

        //检查email是否存在
        validResponse=this.checkValid(userPojo.getEmail(),Const.EMAIL);
        if(!validResponse.isSuccess()){
            //若存在 返回
            return validResponse;
        }

        //密码MD5加密
        userPojo.setPassword(MD5Util.MD5EncodeUtf8(userPojo.getPassword()));

        int resultCount=userPojoMapper.insert(userPojo);
        if(resultCount==0){
            return ServerResponse.createByErrorMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }

    public ServerResponse<String> checkValid(String str,String type){
        //trim操作后type是否为空
        if(StringUtils.isNotBlank(type)){
            //检查用户名是否存在
            if(Const.USERNAME.equals(type)){
                int resultCount=userPojoMapper.checkUsername(str);
                if(resultCount>0){
                    return ServerResponse.createByErrorMessage("用户名已存在");
                }
            }
            //检查email是否存在
            if(Const.EMAIL.equals(type)){
                int resultCount=userPojoMapper.checkUsername(str);
                if(resultCount>0){
                    return ServerResponse.createByErrorMessage("email已存在");
                }
            }
        }else{
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }

    @Override
    public ServerResponse<String> sendEmailVericode(String email) {
        //初始化code
        int code=0;
        try {
            //使用发送邮件的工具类 发送验证码
            code= EmailHelper.sendEmailVerCode(email);
        } catch (MessagingException e) {
            //若抛出异常 返回
            return ServerResponse.createByErrorMessage("无法发送验证码");
        }
        if(code==0){
            //若code仍是0 返回
            return ServerResponse.createByErrorMessage("发送验证码失败");
        }
        //返回成功
        String vericode=MD5Util.MD5EncodeUtf8(Integer.toString(code));
        return ServerResponse.createBySuccess("发送成功",vericode);
    }

}
