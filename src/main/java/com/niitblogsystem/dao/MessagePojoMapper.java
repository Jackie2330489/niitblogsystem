package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.MessagePojo;

public interface MessagePojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessagePojo record);

    int insertSelective(MessagePojo record);

    MessagePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessagePojo record);

    int updateByPrimaryKey(MessagePojo record);
}