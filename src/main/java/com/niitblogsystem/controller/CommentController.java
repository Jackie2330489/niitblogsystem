package com.niitblogsystem.controller;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.ICommentService;
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
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private ICommentService iCommentService;

    ////评论模块
    //发表评论
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createComment(long postid, String passive, String comment, HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iCommentService.createComment(postid,active,passive,comment);
    }
    //删除评论
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delComment(long id,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iCommentService.delComment(id,active);
    }
    //查看评论
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listComment(long postid, int pageNum, int pageSize){
        return iCommentService.postComment(postid,pageNum,pageSize);
    }
    //查看个人评论
    @RequestMapping(value="/inmypost",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> commentInmypost(int pageNum,int pageSize,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取当前用户名
        String active=userPojo.getUsername();
        return iCommentService.userComment(active,pageNum,pageSize);
    }
}
