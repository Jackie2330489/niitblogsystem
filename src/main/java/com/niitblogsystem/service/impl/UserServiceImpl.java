package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.List;

/**
 * Created by Justin on 2017/9/12.
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserPojoMapper userPojoMapper;

    ////用户块
    //登录
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
    //注册
    @Override
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
    //检查用户名或email有效性
    @Override
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
                int resultCount=userPojoMapper.checkEmail(str);
                if(resultCount>0){
                    return ServerResponse.createByErrorMessage("email已存在");
                }
            }
        }else{
            return ServerResponse.createByErrorMessage("参数错误");
        }
        return ServerResponse.createBySuccessMessage("校验成功");
    }
    //发送email验证码
    @Override
    public ServerResponse<String> sendEmailVericode(String email) {
        //初始化code
        Integer code=0;
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
        String vericode=MD5Util.MD5EncodeUtf8(code.toString());
        return ServerResponse.createBySuccess("发送成功",vericode);
    }
    //查看别人信息
    @Override
    public ServerResponse<UserPojo> viewInfo(String username){
        //数据库中查找username
        UserPojo userPojo=userPojoMapper.selectByUsername(username);
        if(userPojo!=null){
            //若查找成功 把密码设为空 返回成功
            userPojo.setPassword("");
            return ServerResponse.createBySuccess("查找成功",userPojo);
        }
        //查找不成功 返回失败
        return ServerResponse.createByErrorMessage("不存在该用户");
    }
    //更新用户
    @Override
    public ServerResponse<String> updateUser(UserPojo userPojo){
        int resultColumn=userPojoMapper.updateByPrimaryKeySelective(userPojo);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }
    //重置密码
    @Override
    public ServerResponse<String> resetPassword(long id,String password){
        //MD5加密password
        password=MD5Util.MD5EncodeUtf8(password);
        int resultColumn=userPojoMapper.resetPassword(id,password);
        if(resultColumn>0){
            //更新行数大于0 重置成功
            return ServerResponse.createBySuccessMessage("重置密码成功");
        }
        //重置失败
        return ServerResponse.createByErrorMessage("重置密码失败");
    }
    ////管理块
    //删除用户
    @Override
    public ServerResponse<String> delUser(long id){
        int resultColumn=userPojoMapper.deleteByPrimaryKey(id);
        if(resultColumn>0){
            //受影响行数大于0 删除成功
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
    //查看用户列表
    @Override
    public ServerResponse<PageInfo> getUserList(String fuzzy, int pageNum, int pageSize, String orderBy){
        //设置PageHelper参数
        PageHelper.startPage(pageNum,pageSize,orderBy);
        if(StringUtils.isNotBlank(fuzzy)){
            //trim操作若不为空 %?% 模糊搜索关键字
            fuzzy=new StringBuilder().append("%").append(fuzzy).append("%").toString();
        }
        List<UserPojo> users=userPojoMapper.selectList(fuzzy);
        PageInfo pageInfo=new PageInfo(users);
        pageInfo.setList(users);
        return ServerResponse.createBySuccess("返回列表成功",pageInfo);
    }
}
