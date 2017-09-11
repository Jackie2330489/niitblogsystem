package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.FollowPojo;

public interface FollowPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FollowPojo record);

    int insertSelective(FollowPojo record);

    FollowPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FollowPojo record);

    int updateByPrimaryKey(FollowPojo record);
}