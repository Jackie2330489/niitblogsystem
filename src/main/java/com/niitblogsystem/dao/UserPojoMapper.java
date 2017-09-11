package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.UserPojo;

public interface UserPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);
}