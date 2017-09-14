package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.ChatPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChatPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChatPojo record);

    int insertSelective(ChatPojo record);   //进行非空判断 遇到空值会以数据库中default的默认值插入

    ChatPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChatPojo record);

    int updateByPrimaryKey(ChatPojo record);

    List<ChatPojo> selectList(@Param("active") String active,@Param("passive") String passive);
}