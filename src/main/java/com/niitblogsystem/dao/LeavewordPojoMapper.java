package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.LeavewordPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeavewordPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LeavewordPojo record);

    int insertSelective(LeavewordPojo record);

    LeavewordPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeavewordPojo record);

    int updateByPrimaryKey(LeavewordPojo record);

    int deleteByIdAndUsername(@Param("id") long id,@Param("username") String username);

    List<LeavewordPojo> selectList(String username);
}