package com.niitblogsystem.controller.manager;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.Const;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;
import com.niitblogsystem.service.ISensitiveService;
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
@RequestMapping("/manage/sensitive")
public class SensitiveManagerController {

    @Autowired
    private ISensitiveService iSensitiveService;

    ////敏感信息管理
    //添加敏感信息
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> addSensitive(String word, HttpSession session){
        UserPojo manager= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(manager.getId()!=1){
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
        return iSensitiveService.addSensitive(word);
    }
    //删除敏感信息
    @RequestMapping(value="/del",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> delSensitive(long id,HttpSession session){
        UserPojo manager= (UserPojo) session.getAttribute(Const.CURRENT_USER);
        if(manager.getId()!=1){
            return ServerResponse.createByErrorMessage("需要管理员权限");
        }
        return iSensitiveService.delSensitive(id);
    }
    //查看敏感信息表
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> listSensitive(int pageNum, int pageSize){
        return iSensitiveService.listSensitive(pageNum,pageSize);
    }
}
