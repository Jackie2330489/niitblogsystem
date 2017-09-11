package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.PostPojo;

public interface PostPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PostPojo record);

    int insertSelective(PostPojo record);

    PostPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PostPojo record);

    int updateByPrimaryKey(PostPojo record);
}