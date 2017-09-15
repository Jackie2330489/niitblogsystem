package com.niitblogsystem.controller;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.ILeavewordService;
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
@RequestMapping("/leaveword")
public class LeavewordController {

    @Autowired
    private ILeavewordService iLeavewordService;

    ////留言模块
    //发表留言
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createLeaveword(String passive,String leaveword,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iLeavewordService.createLeaveword(active,passive,leaveword);
    }
    //查看留言墙
    @RequestMapping(value="/wall",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> viewLeaveword(int pageNum,int pageSize,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iLeavewordService.wallLeaveword(active,pageNum,pageSize);
    }
    //删除留言
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delLeaveword(long id,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iLeavewordService.delLeaveword(active,id);
    }
}
