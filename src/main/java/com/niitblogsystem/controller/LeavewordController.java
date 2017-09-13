package com.niitblogsystem.controller;

import com.niitblogsystem.common.ServerResponse;
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
    //    @Autowired

    ////留言模块
    //发表留言
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> createLeaveword(String passive,String leaveword){
        //todo
        return null;
    }
    //查看留言墙
    @RequestMapping(value="/wall",method= RequestMethod.GET)
    @ResponseBody
    public ServerResponse<String> viewLeaveword(HttpSession session){
        //todo
        return null;
    }
    //删除留言
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delLeaveword(long id,HttpSession session){
        //todo
        return null;
    }
}
