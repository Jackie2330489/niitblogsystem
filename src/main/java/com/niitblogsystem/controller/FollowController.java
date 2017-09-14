package com.niitblogsystem.controller;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Justin on 2017/9/14.
 */
@Controller
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private IFollowService iFollowService;

    ////关注模块
    //关注
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createFollow(String passive, HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iFollowService.createFollow(active,passive);
    }
    //取消关注
    @RequestMapping(value="/disfollow",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delFollow(String passive, HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iFollowService.delFollow(active,passive);
    }
    //查看关注列表
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listFollow(String username,int pageNum,int pageSize){
        return iFollowService.listFollow(username,pageNum,pageSize);
    }
}
