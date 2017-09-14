package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.CommentPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Justin on 2017/9/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CommentPojoMapperTest {

    @Autowired
    private CommentPojoMapper commentPojoMapper;

    @Test
    public void postComments() throws Exception {
        List<CommentPojo> commentPojoList=commentPojoMapper.postComments(1L);
        System.out.println(commentPojoList.size());
    }

    @Test
    public void userComments() throws Exception {
        List<CommentPojo> commentPojoList=commentPojoMapper.userComments("Banana");
        System.out.println(commentPojoList.size());
    }

}