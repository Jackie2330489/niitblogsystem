package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.pojo.UserPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Justin on 2017/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IUserServiceTest {

    @Resource
    private IUserService iUserService;

    @Test
    public void login() throws Exception {
    }

    @Test
    public void register() throws Exception {
    }

    @Test
    public void checkValid() throws Exception {
    }

    @Test
    public void sendEmailVericode() throws Exception {
    }

    @Test
    public void getUserList() throws Exception {
        PageInfo pageInfo=iUserService.getUserList("ap",1,10,"username asc").getData();
        List<UserPojo> userPojos= pageInfo.getList();
        for(UserPojo userPojo:userPojos){
            System.out.println(userPojo.getId()+userPojo.getUsername()+userPojo.getEmail());
        }
    }

}