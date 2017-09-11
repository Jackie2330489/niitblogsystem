package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.SensitivePojo;

public interface SensitivePojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SensitivePojo record);

    int insertSelective(SensitivePojo record);

    SensitivePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SensitivePojo record);

    int updateByPrimaryKey(SensitivePojo record);
}