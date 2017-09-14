package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;

/**
 * Created by Justin on 2017/9/14.
 */
public interface ICommentService {

    ServerResponse<String> createComment(long postid,String active,String passive,String comment);

    ServerResponse<String> delComment(long id,String active);

    ServerResponse<PageInfo> postComment(long postid,int pageNum,int pageSize);

    ServerResponse<PageInfo> userComment(String active,int pageNum,int pageSize);
}
