package com.niitblogsystem.controller;

import com.niitblogsystem.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Justin on 2017/9/13.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {
    //    @Autowired

    ////私信模块
    //发表私信
    @RequestMapping(value="/send",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> sendChat(String passive, String msg){
        //todo
        return null;
    }
    //查看私信
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> listChat(String passive, int pagNum,int pageSize){
        //todo
        return null;
    }
}
