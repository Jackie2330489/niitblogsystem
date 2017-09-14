package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.SensitivePojo;
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
public class SensitivePojoMapperTest {

    @Resource
    private SensitivePojoMapper sensitivePojoMapper;

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
    public void selectList() throws Exception {
        List<SensitivePojo> sensitivePojoList=sensitivePojoMapper.selectList();
        for(SensitivePojo sensitivePojo:sensitivePojoList){
            System.out.println(sensitivePojo.getId()+sensitivePojo.getWord());
        }
    }

}