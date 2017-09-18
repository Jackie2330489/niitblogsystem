package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.PostPojo;
import net.sf.jsqlparser.schema.Server;

/**
 * Created by Justin on 2017/9/14.
 */
public interface IPostService {

    ServerResponse<String> createPost(String author,String title,String body,int status,String tags);

    ServerResponse<String> delPost(String username,long postid);

    ServerResponse<String> updatePost(long postid,String title,String body,int status,String author);

    ServerResponse<String> updatePostStatus(String username,long id,int status);

    ServerResponse<String> delPostRoot(long postid);

    ServerResponse<String> updatePostStatusRoot(long postid,int status);

    ServerResponse<PostPojo> getPost(long id);

    ServerResponse<PageInfo> getPostList(String author,int pageNum,int pageSize,String orderby);
}
