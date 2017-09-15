package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.MessageType;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.FollowPojoMapper;
import com.niitblogsystem.dao.MessagePojoMapper;
import com.niitblogsystem.pojo.FollowPojo;
import com.niitblogsystem.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iFollowService")
public class FollowServiceImpl implements IFollowService{

    @Autowired
    private FollowPojoMapper followPojoMapper;

    ////关注模块
    //关注
    @Override
    public ServerResponse<String> createFollow(String active, String passive) {
        //填充followpojo
        FollowPojo followPojo=new FollowPojo();
        followPojo.setActive(active);
        followPojo.setPassive(passive);
        int resultColumn=followPojoMapper.insertSelective(followPojo);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("关注成功");
        }
        return ServerResponse.createByErrorMessage("关注失败");
    }
    //取消关注
    @Override
    public ServerResponse<String> delFollow(String active, String passive) {
        int resultColumn=followPojoMapper.deleteByActivePassive(active,passive);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
    //获取关注列表
    @Override
    public ServerResponse<PageInfo> listFollow(String username,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize,"cretime desc");
        List<FollowPojo> followPojoList=followPojoMapper.selectList(username);
        PageInfo pageInfo=new PageInfo(followPojoList);
        pageInfo.setList(followPojoList);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }
}
