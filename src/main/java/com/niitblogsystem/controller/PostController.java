package com.niitblogsystem.controller;

import com.niitblogsystem.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Justin on 2017/9/13.
 */
@Controller
@RequestMapping("/post")
public class PostController {
//    @Autowired

    ////博文模块
    //发表博文
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createPost(String author,String title,String body,int status,String tags){
        //todo
        return null;
    }
    //删除博文
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delPost(long id){
        //todo
        return null;
    }
    //更新博文
    @RequestMapping(value="/update",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updatePost(String title,String body,int status,String tags){
        //todo
        return null;
    }
    //修改博文状态
    @RequestMapping(value="/update_status",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updatePostStatus(long id,int status){
        //todo
        return null;
    }
    //查看博文
    @RequestMapping(value="/view/{id}",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> viewPost(@PathVariable long id){
        //todo
        return null;
    }
    //查看博文列表
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> listPost(String author,int pageNum,int pageSize,String orderBy){
        //todo
        return null;
    }
}
