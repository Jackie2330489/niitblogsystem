package com.niitblogsystem.service.impl;

import com.niitblogsystem.dao.PostPojoMapper;
import com.niitblogsystem.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iPostService")
public class PostServiceImpl implements IPostService {

    @Autowired
    private PostPojoMapper postPojoMapper;
}
