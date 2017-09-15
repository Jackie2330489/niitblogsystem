package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.TagPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Justin on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TagPojoMapperTest {

    @Autowired
    private TagPojoMapper tagPojoMapper;

    @Test
    public void insertSelective() throws Exception {
        TagPojo tagPojo=new TagPojo();
        tagPojo.setTagname("Kotwwil");
        tagPojoMapper.insertSelective(tagPojo);
        System.out.println(tagPojo.getId());
    }

    @Test
    public void selectByPostid() throws Exception {
        List<TagPojo> tagPojos= tagPojoMapper.selectByPostid(1L);
        for(TagPojo tagPojo:tagPojos){
            System.out.println(tagPojo.getTagname());
        }
    }

    @Test
    public void insertTag2Post() throws Exception{
//        tagPojoMapper.insertTag2Post(1L,4L);
        System.out.println(tagPojoMapper.selectId("Hello"));
    }

}