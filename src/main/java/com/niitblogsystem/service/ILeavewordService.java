package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;

/**
 * Created by Justin on 2017/9/14.
 */
public interface ILeavewordService {

    ServerResponse<String> createLeaveword(String active,String passive,String leaveword);

    ServerResponse<PageInfo> wallLeaveword(String username,int pageNum,int pageSize);

    ServerResponse<String> delLeaveword(String username,long id);
}
