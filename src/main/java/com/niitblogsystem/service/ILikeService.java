package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;

/**
 * Created by Justin on 2017/9/14.
 */
public interface ILikeService {

    ServerResponse<String> createLike(String active,String passive,long postid);

    ServerResponse<PageInfo> listLike(String username,int pageNum,int pageSize);
}
