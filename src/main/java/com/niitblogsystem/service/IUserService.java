package com.niitblogsystem.service;

import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.pojo.UserPojo;

/**
 * Created by Justin on 2017/9/12.
 */
public interface IUserService {

    ServerResponse<UserPojo> login(String username, String password);

    ServerResponse<String> register(UserPojo userPojo);

    ServerResponse<String> checkValid(String str,String type);
}
