package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;

/**
 * Created by Justin on 2017/9/14.
 */
public interface IChatService {
    ServerResponse<String> sendChat(String active,String passive,String msg);

    ServerResponse<PageInfo> listChat(String active,String passive,int pageNum,int pageSize);
}
