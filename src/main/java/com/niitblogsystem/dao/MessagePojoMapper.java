package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.MessagePojo;
import org.apache.ibatis.annotations.Param;

public interface MessagePojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessagePojo record);

    int insertSelective(MessagePojo record);

    MessagePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessagePojo record);

    int updateByPrimaryKey(MessagePojo record);

    int insertMessage(@Param("username")String username,@Param("msgType")int msgType,@Param("status")int status);

    int readMessages(@Param("username") String username, @Param("msgType") int msgType);
}