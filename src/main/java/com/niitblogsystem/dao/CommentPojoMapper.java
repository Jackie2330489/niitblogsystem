package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.CommentPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentPojo record);

    int insertSelective(CommentPojo record);

    CommentPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentPojo record);

    int updateByPrimaryKey(CommentPojo record);

    int deleteByIdAndUsername(@Param("id") long id,@Param("active") String active);

    List<CommentPojo> postComments(long postid);

    List<CommentPojo> userComments(String active);
}