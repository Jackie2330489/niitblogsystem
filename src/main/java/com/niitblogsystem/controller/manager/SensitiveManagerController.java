package com.niitblogsystem.controller.manager;

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
@RequestMapping("/manage/sensitive")
public class SensitiveManagerController {

//    @Autowired

    ////敏感信息管理
    //添加敏感信息
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addSensitive(String word){
        //todo
        return null;
    }
    //删除敏感信息
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delSensitive(long id){
        //todo
        return null;
    }
    //查看敏感信息表
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> listSensitive(int pageNum,int pageSize){
        //todo
        return null;
    }
}
