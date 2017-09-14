package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.ChatPojo;
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
public class ChatPojoMapperTest {

    @Resource
    private ChatPojoMapper chatPojoMapper;

    @Test
    public void selectList() throws Exception {
        List<ChatPojo> pojos=chatPojoMapper.selectList("Banana","Apple");
        for(ChatPojo chatPojo:pojos){
            System.out.println(chatPojo.getPassive()+" to "+chatPojo.getActive()+":"+chatPojo.getMsg());
        }
    }

}