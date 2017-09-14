package com.niitblogsystem.dao;

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
public class UserPojoMapperTest {

    @Resource
    private UserPojoMapper userPojoMapper;

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }

    @Test
    public void checkUsername() throws Exception {
    }

    @Test
    public void checkEmail() throws Exception {
    }

    @Test
    public void selectLogin() throws Exception {
    }

    @Test
    public void selectList() throws Exception {
        List<UserPojo> userPojos=userPojoMapper.selectList("");
        for(UserPojo userPojo:userPojos){
            System.out.println(userPojo.getId()+userPojo.getUsername()+userPojo.getEmail());
        }
    }

    @Test
    public void selectByUsername() throws  Exception{
        UserPojo userPojo=userPojoMapper.selectByUsername("Apple");
        System.out.println(userPojo.getId()+userPojo.getUsername());
    }

}