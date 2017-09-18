package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.PostPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PostPojo record);

    int insertSelective(PostPojo record);

    PostPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PostPojo record);

    int updateByPrimaryKey(PostPojo record);

    int deleteByIdAndAuthor(@Param("author") String author,@Param("postid") long postid);

    int updatePostStatus(@Param("username") String username,@Param("id") long id,@Param("status") int status);

    int updatePostStatusRoot(@Param("id")long id,@Param("status") int status);

    List<PostPojo> selectPostList(String author);
}