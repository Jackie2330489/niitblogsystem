package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.PostPojo;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by Justin on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class PostPojoMapperTest {

    @Resource
    private PostPojoMapper postPojoMapper;

    @Test
    public void insertSelective() throws Exception {
        PostPojo postPojo=new PostPojo();
        postPojo.setAuthor("Apple");
        postPojo.setStatus(1);
        postPojo.setBody("for the test");
        postPojo.setTitle("for the test");
        int postid=postPojoMapper.insertSelective(postPojo);
        System.out.println(postPojo.getId());
//        String[] splists=StringUtils.split("a,sdasd,wqdwqw,casasd,asdasd",',');
//        for(String s:splists){
//            System.out.println(s);
//        }
    }

    @Test
    public void test2() throws Exception{
        postPojoMapper.deleteByIdAndAuthor("Apple",1L);
    }
}