package com.niitblogsystem.service;

import com.niitblogsystem.dao.TagPojoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Justin on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ITagServiceTest {

    @Resource
    private ITagService iTagService;

    @Test
    public void handleTags() throws Exception {
        List<String> tags=new ArrayList<>();
        tags.add("Hello");
        tags.add("papillion");
        int i=iTagService.handleTags(1L,tags);
        System.out.println(i);
    }

}