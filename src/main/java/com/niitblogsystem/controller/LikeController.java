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
@RequestMapping("/like")
public class LikeController {
//    @Autowired

    ////点赞模块
    //点赞
    @RequestMapping(value="/send",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createLike(String passive,int postid){
        //todo
        return null;
    }
    //查看点赞
    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> listLike(int pageNum,int pageSize){
        //todo
        return null;
    }
}
