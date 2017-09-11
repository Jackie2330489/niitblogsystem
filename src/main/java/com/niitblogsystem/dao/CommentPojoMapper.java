package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.CommentPojo;

public interface CommentPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentPojo record);

    int insertSelective(CommentPojo record);

    CommentPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentPojo record);

    int updateByPrimaryKey(CommentPojo record);
}