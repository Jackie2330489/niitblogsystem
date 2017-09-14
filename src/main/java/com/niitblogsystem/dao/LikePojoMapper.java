package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.LikePojo;

import java.util.List;

public interface LikePojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LikePojo record);

    int insertSelective(LikePojo record);

    LikePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LikePojo record);

    int updateByPrimaryKey(LikePojo record);

    List<LikePojo> selectList(String username);
}