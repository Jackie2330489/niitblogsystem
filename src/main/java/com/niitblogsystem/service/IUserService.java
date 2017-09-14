package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;

/**
 * Created by Justin on 2017/9/12.
 */
public interface IUserService {

    ServerResponse<UserPojo> login(String username, String password);

    ServerResponse<String> register(UserPojo userPojo);

    ServerResponse<String> checkValid(String str,String type);

    ServerResponse<String> sendEmailVericode(String email);

    ServerResponse<PageInfo> getUserList(String fuzzy, int pageNum, int pageSize, String orderBy);

    ServerResponse<UserPojo> viewInfo(String username);

    ServerResponse<String> updateUser(UserPojo userPojo);

    ServerResponse<String> resetPassword(long id,String password);

    ServerResponse<String> delUser(long id);
}
