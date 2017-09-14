package com.niitblogsystem.dao;

import com.niitblogsystem.pojo.SensitivePojo;

import java.util.List;

public interface SensitivePojoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SensitivePojo record);

    int insertSelective(SensitivePojo record);

    SensitivePojo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SensitivePojo record);

    int updateByPrimaryKey(SensitivePojo record);

    List<SensitivePojo> selectList();
}