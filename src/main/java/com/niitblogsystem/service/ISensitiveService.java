package com.niitblogsystem.service;

import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.SensitivePojoMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Justin on 2017/9/14.
 */
public interface ISensitiveService {

    ServerResponse<String> addSensitive(String word);

    ServerResponse<String> delSensitive(long id);

    ServerResponse<PageInfo> listSensitive(int pageNum,int pageSize);
}
