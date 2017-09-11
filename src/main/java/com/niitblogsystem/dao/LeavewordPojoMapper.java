package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.LeavewordPojo;

public interface LeavewordPojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LeavewordPojo record);

    int insertSelective(LeavewordPojo record);

    LeavewordPojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeavewordPojo record);

    int updateByPrimaryKey(LeavewordPojo record);
}