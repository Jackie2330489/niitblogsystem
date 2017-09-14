package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;

/**
 * Created by Justin on 2017/9/14.
 */
public interface IFollowService {

    ServerResponse<String> createFollow(String active,String passive);

    ServerResponse<String> delFollow(String active,String passive);

    ServerResponse<PageInfo> listFollow(String username,int pageNum,int pageSize);
}
