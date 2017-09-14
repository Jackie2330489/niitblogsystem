package com.niitblogsystem.controller;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.ILikeService;
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
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private ILikeService iLikeService;

    ////点赞模块
    //点赞
    @RequestMapping(value="/send",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createLike(String passive, long postid, HttpSession session){
        //检查登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iLikeService.createLike(active,passive,postid);
    }
    //查看点赞
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listLike(int pageNum, int pageSize, HttpSession session){
        //检查登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String username=userPojo.getUsername();
        return iLikeService.listLike(username,pageNum,pageSize);
    }
}
