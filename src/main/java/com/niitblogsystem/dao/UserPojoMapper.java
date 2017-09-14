package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserPojo record);

    int insertSelective(UserPojo record);

    UserPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserPojo record);

    int updateByPrimaryKey(UserPojo record);

    int checkUsername(String username);

    int checkEmail(String email);

    UserPojo selectLogin(@Param("username") String username,@Param("password") String password);

    List<UserPojo> selectList(@Param("fuzzy") String fuzzy);

    UserPojo selectByUsername(String username);

    int resetPassword(@Param("id") long id,@Param("password") String password);
}