package com.niitblogsystem.dao;

import com.niitblogsystem.common.MessageType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Justin on 2017/9/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MessagePojoMapperTest {

    @Autowired
    private MessagePojoMapper messagePojoMapper;

    @Test
    public void insertMessage() throws Exception {
        messagePojoMapper.insertMessage("Apple", MessageType.CHAT.getCode(),1);
        messagePojoMapper.insertMessage("Apple", MessageType.CHAT.getCode(),0);
        messagePojoMapper.insertMessage("Apple", MessageType.CHAT.getCode(),0);
        messagePojoMapper.insertMessage("Apple", MessageType.CHAT.getCode(),1);
    }

    @Test
    public void readMessages() throws Exception {
    }

}