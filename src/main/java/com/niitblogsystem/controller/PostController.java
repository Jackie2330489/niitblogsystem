package com.niitblogsystem.controller;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.PostPojo;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Justin on 2017/9/13.
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private IPostService iPostService;

    ////博文模块
    //发表博文
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createPost(String title, String body, int status, String tags, HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取用户名
        String author=userPojo.getUsername();
        return iPostService.createPost(author,title,body,status,tags);
    }
    //删除博文
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delPost(long id,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取用户名
        String author=userPojo.getUsername();
        return iPostService.delPost(author,id);
    }
    //更新博文
    @RequestMapping(value="/update",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updatePost(long postid,String title,String body,int status,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取用户名
        String author=userPojo.getUsername();
        return iPostService.updatePost(postid,title,body,status,author);
    }
    //修改博文状态
    @RequestMapping(value="/update_status",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updatePostStatus(long id,int status,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        //获取用户名
        String username=userPojo.getUsername();
        return iPostService.updatePostStatus(username,id,status);
    }
    //查看博文
    @RequestMapping(value="/view/{id}",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PostPojo> viewPost(@PathVariable long id){
        return iPostService.getPost(id);
    }
    //查看博文列表
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<PageInfo> listPost(String author, int pageNum, int pageSize, String orderBy){
        return iPostService.getPostList(author,pageNum,pageSize,orderBy);
    }
}
