package com.niitblogsystem.controller;

import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IUserService;
import com.niitblogsystem.util.EmailHelper;
import com.niitblogsystem.util.MD5Util;
import net.sf.jsqlparser.schema.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

/**
 * Created by Justin on 2017/9/12.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    ////注册模块
    //注册用户
    @RequestMapping(value="/register",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(UserPojo userPojo){
        return iUserService.register(userPojo);
    }

    ////验证模块
    //检查用户名或邮箱
    @RequestMapping(value="/check_valid",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkValid(String str,String type){
        return iUserService.checkValid(str,type);
    }
    //发邮箱验证码
    @RequestMapping(value="/send_email_vericode",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> sendEmailVericode(String email,HttpSession session){
        //发送验证码
        ServerResponse serverResponse=iUserService.sendEmailVericode(email);
        if(serverResponse.isSuccess()){
            //若成功 session保存加密后的验证码
            session.setAttribute(Const.VERICODE,serverResponse.getData());
        }
        //返回发送成功
        return serverResponse;
    }
    //校验验证码
    @RequestMapping(value="/veri_email_vericode",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> veriEmailVericode(Integer vericode,HttpSession session){
        //验证码Integer转String
        String md5veri=vericode.toString();
        //获取session的vericode
        String realmd5veri= (String) session.getAttribute(Const.VERICODE);
        //校验验证码
        if(md5veri.equals(realmd5veri)){
            return ServerResponse.createBySuccessMessage("验证码正确");
        }
        return ServerResponse.createByErrorMessage("验证码错误");
    }

    ////登录模块
    //登录
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserPojo> login(String username, String password, HttpSession session) {
        //检证用户名密码
        ServerResponse<UserPojo> response = iUserService.login(username, password);
        if (response.isSuccess()) {
            //成功 session保存UserPojo
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }
    //登出
    @RequestMapping(value="/logout",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        //删除session中的UserPojo
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("登出成功");
    }

    ////个人信息模块
    //查看别人信息
    @RequestMapping(value="/view/{username}",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<UserPojo> viewInfo(@PathVariable String username){
        return iUserService.viewInfo(username);
    }
    //查看个人信息
    @RequestMapping(value="/view_myself",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<UserPojo> viewMyInfo(HttpSession session){
        //从session中获取UserPojo
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            //若为空 返回未登录
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        //返回个人的UserPojo
        return ServerResponse.createBySuccess(userPojo);
    }
    //修改个人信息
    @RequestMapping(value="/update",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updateInfo(UserPojo userPojo,HttpSession session){
        //把userPojo的password置空
        userPojo.setPassword(null);
        UserPojo currentUser= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo.getId()!=currentUser.getId()){
            //若待更新的userPojo的id与session中的userPojo的id不一致
            return ServerResponse.createByErrorMessage("更新失败：登录用户与更新用户不一致");
        }
        //调用service层更新用户
        ServerResponse serverResponse=iUserService.updateUser(userPojo);
        if(serverResponse.isSuccess()){
            //更新成功 重新设置session中的UserPojo
            session.setAttribute(Const.CURRENT_USER,serverResponse.getData());
        }
        //返回更新消息
        return serverResponse;
    }
    //重置密码
    @RequestMapping(value="/reset_password",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(String password,HttpSession session){
        //获取session中的UserPojo的id
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        long id=userPojo.getId();
        return iUserService.resetPassword(id,password);
    }
}
