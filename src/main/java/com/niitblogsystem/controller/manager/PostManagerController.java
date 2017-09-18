package com.niitblogsystem.controller.manager;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IPostService;
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
@RequestMapping("/manage/post")
public class PostManagerController {

    @Autowired
    private IPostService iPostService;

    ////博文管理模块
    //添加管理员博文
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addManagerPost(String title, String body, int status, String tags, HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        if(userPojo.getId()!=1){
            return ServerResponse.createByErrorMessage("需要管理员登录");
        }
        //获取用户名
        String username=userPojo.getUsername();
        return iPostService.createPost(username,title,body,status,tags);
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
        if(userPojo.getId()!=1){
            return ServerResponse.createByErrorMessage("需要管理员登录");
        }
        return iPostService.delPostRoot(id);
    }
    //修改博文状态
    @RequestMapping(value="/status",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updatePostStatus(long id,int status,HttpSession session){
        //验证登录状态
        UserPojo userPojo= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(userPojo==null){
            return ServerResponse.createByErrorMessage("请先登录");
        }
        if(userPojo.getId()!=1){
            return ServerResponse.createByErrorMessage("需要管理员登录");
        }
        return iPostService.updatePostStatusRoot(id,status);
    }
    //查看博文列表
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> listPost(String author, int pageNum, int pageSize, String orderBy){
        return iPostService.getPostList(author,pageNum,pageSize,orderBy);
    }
}
