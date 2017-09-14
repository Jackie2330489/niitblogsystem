package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.FollowPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class FollowPojoMapperTest {

    @Resource
    private FollowPojoMapper followPojoMapper;

    @Test
    public void deleteByActivePassive() throws Exception {
        int result=followPojoMapper.deleteByActivePassive("Banana","Apple");
        System.out.println(result);
    }

    @Test
    public void selectList() throws Exception {
        List<FollowPojo> followPojos=followPojoMapper.selectList("Banana");
        System.out.println(followPojos.size());
    }

}