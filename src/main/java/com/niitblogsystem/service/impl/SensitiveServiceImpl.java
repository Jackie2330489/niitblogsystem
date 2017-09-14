package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.SensitivePojoMapper;
import com.niitblogsystem.pojo.SensitivePojo;
import com.niitblogsystem.service.ISensitiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iSensitiveService")
public class SensitiveServiceImpl implements ISensitiveService {

    @Autowired
    private SensitivePojoMapper sensitivePojoMapper;

    //敏感信息管理块
    //添加敏感信息
    @Override
    public ServerResponse<String> addSensitive(String word) {
        SensitivePojo sensitivePojo=new SensitivePojo();
        sensitivePojo.setWord(word);
        int resultColumn=sensitivePojoMapper.insertSelective(sensitivePojo);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }
    //删除敏感信息
    @Override
    public ServerResponse<String> delSensitive(long id) {
        int resultColumn=sensitivePojoMapper.deleteByPrimaryKey(id);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
    //查看敏感信息列表
    @Override
    public ServerResponse<PageInfo> listSensitive(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<SensitivePojo> sensitives=sensitivePojoMapper.selectList();
        PageInfo pageInfo=new PageInfo(sensitives);
        pageInfo.setList(sensitives);
        return ServerResponse.createBySuccess("返回列表成功",pageInfo);
    }
}
