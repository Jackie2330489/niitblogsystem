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

    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<UserPojo> login(String username, String password, HttpSession session){
        ServerResponse<UserPojo> response=iUserService.login(username,password);
        if(response.isSuccess()){
            session.setAttribute(Const.CURRENT_USER,response.getData());
        }
        return response;
    }

    @RequestMapping(value="/logout",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session){
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccessMessage("登出成功");
    }

    @RequestMapping(value="/register",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(UserPojo userPojo){
        return iUserService.register(userPojo);
    }

    @RequestMapping(value="/check_valid",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> checkValid(String str,String type){
        return iUserService.checkValid(str,type);
    }

    @RequestMapping(value="/send_email_vericode",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> sendEmailVericode(String email,HttpSession session){
        //初始化code
        int code=0;
        try {
            //使用发送邮件的工具类 发送验证码
            code=EmailHelper.sendEmailVerCode(email);
        } catch (MessagingException e) {
            //若抛出异常 返回
            return ServerResponse.createByErrorMessage("无法发送验证码");
        }
        if(code==0){
            //若code仍是0 返回
            return ServerResponse.createByErrorMessage("发送验证码失败");
        }
        //加密验证码并存到session中
        String vericode=MD5Util.MD5EncodeUtf8(Integer.toString(code));
        session.setAttribute(Const.VERICODE,vericode);
        //返回发送成功
        return ServerResponse.createBySuccessMessage("发送成功");
    }

    @RequestMapping(value="/veri_email_vericode",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> veriEmailVericode(int vericode,HttpSession session){
        String md5veri=Integer.toString(vericode);
        String realmd5veri= (String) session.getAttribute(Const.VERICODE);
        if(md5veri.equals(realmd5veri)){
            return ServerResponse.createBySuccessMessage("验证码正确");
        }
        return ServerResponse.createByErrorMessage("验证码错误");
    }

    @RequestMapping(value="/get_user_info",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<UserPojo> getUserInfo(HttpSession session){
        UserPojo userPojo=(UserPojo)session.getAttribute(Const.CURRENT_USER);
        if(userPojo!=null){
            return ServerResponse.createBySuccess(userPojo);
        }
        return ServerResponse.createByErrorMessage("用户未登录，无法获取当前用户信息");
    }
}
