package com.niitblogsystem.controller.manager;

import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Justin on 2017/9/13.
 */
@Controller
@RequestMapping("/manage/post")
public class PostManagerController {

//    @Autowired

    ////博文管理模块
    //添加管理员博文
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addManagerPost(String author,String title,String body,int status,String tags){
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
    //修改博文状态
    @RequestMapping(value="/status",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> updatePostStatus(long id,int status){
        //todo
        return null;
    }
    //查看博文列表
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> listPost(String author,String tags,int pageNum,int pageSize,String orderBy){
        //todo
        return null;
    }
}
