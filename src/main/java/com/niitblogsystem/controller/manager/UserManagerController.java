package com.niitblogsystem.controller.manager;

import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Justin on 2017/9/12.
 */
@Controller
@RequestMapping("/manage/user")
public class UserManagerController {

    @Autowired
    private IUserService iUserService;

    ////用户管理模块
    //添加用户
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addUser(UserPojo userPojo){
        //todo
        return null;
    }
    //删除用户
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delUser(long id){
        //todo
        return null;
    }
    //查看用户列表
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> listUser(String fuzzy,int pageNum,int pageSize,String orderBy){
        //todo
        return null;
    }

}
