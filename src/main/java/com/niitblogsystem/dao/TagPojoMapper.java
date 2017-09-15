package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.TagPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TagPojo record);

    int insertSelective(TagPojo record);

    TagPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TagPojo record);

    int updateByPrimaryKey(TagPojo record);

    int insertTag2Post(@Param("postid") long postid,@Param("tagid") long tagid);

    Integer selectId(String tagname);

    List<TagPojo> selectByPostid(long postid);
}