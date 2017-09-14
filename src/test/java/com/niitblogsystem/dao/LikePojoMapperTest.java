package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.LikePojo;
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
public class LikePojoMapperTest {

    @Autowired
    private LikePojoMapper likePojoMapper;

    @Test
    public void selectList() throws Exception {
        List<LikePojo> likePojoList=likePojoMapper.selectList("Apple");
        System.out.println(likePojoList.size());
    }

}