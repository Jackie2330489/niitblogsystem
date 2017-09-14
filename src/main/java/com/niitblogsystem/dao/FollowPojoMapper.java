package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.FollowPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FollowPojo record);

    int insertSelective(FollowPojo record);

    FollowPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FollowPojo record);

    int updateByPrimaryKey(FollowPojo record);

    int deleteByActivePassive(@Param("active") String active,@Param("passive") String passive);

    List<FollowPojo> selectList(String username);
}