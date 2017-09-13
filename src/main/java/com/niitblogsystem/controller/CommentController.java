package com.niitblogsystem.controller;

import com.niitblogsystem.common.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Justin on 2017/9/13.
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
//    @Autowired

    ////评论模块
    //发表评论
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createComment(long postid,String active,String passive,String comment){
        //todo
        return null;
    }
    //删除评论
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delComment(long id){
        //todo
        return null;
    }
    //查看评论
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> listComment(long postid,int pageNum,int pageSize){
        //todo
        return null;
    }
    //查看个人评论
    @RequestMapping(value="/inmypost",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> commentInmypost(int pageNum,int pageSize){
        //todo
        return null;
    }
}
