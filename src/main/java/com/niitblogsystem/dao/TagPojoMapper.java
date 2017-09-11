package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.TagPojo;

public interface TagPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagPojo record);

    int insertSelective(TagPojo record);

    TagPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagPojo record);

    int updateByPrimaryKey(TagPojo record);
}