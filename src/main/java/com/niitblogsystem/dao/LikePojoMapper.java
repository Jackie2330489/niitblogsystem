package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.LikePojo;

public interface LikePojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LikePojo record);

    int insertSelective(LikePojo record);

    LikePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LikePojo record);

    int updateByPrimaryKey(LikePojo record);
}