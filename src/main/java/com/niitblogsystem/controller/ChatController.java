package com.niitblogsystem.controller;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Justin on 2017/9/13.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private IChatService iChatService;
    ////私信模块
    //发表私信
    @RequestMapping(value="/send",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> sendChat(String passive, String msg, HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iChatService.sendChat(active,passive,msg);
    }
    //查看私信
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> listChat(String passive, int pagNum, int pageSize, HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iChatService.listChat(active,passive,pagNum,pageSize);
    }
}
