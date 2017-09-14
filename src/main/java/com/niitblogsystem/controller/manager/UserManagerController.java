package com.niitblogsystem.controller.manager;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
    public ServerResponse<String> addUser(UserPojo userPojo, HttpSession session){
        //获取session的管理员UserPojo
        UserPojo manager= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(manager.getId()!=1){
            //管理员id为1 若不为1 则操作失败
            return ServerResponse.createByErrorMessage("操作失败 需要管理员权限");
        }
        return iUserService.register(userPojo);
    }
    //删除用户
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delUser(long id,HttpSession session){
        //获取session的管理员UserPojo
        UserPojo manager= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(manager.getId()!=1){
            //管理员id为1 若不为1 则操作失败
            return ServerResponse.createByErrorMessage("操作失败 需要管理员权限");
        }
        return iUserService.delUser(id);
    }
    //查看用户列表
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> listUser(String fuzzy, @RequestParam(value="pageNum",defaultValue = "1") int pageNum, @RequestParam(value="pageSize",defaultValue = "10") int pageSize, String orderBy){
        return iUserService.getUserList(fuzzy,pageNum,pageSize,orderBy);
    }

}
