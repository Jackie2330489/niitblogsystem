package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.LeavewordPojoMapper;
import com.niitblogsystem.pojo.LeavewordPojo;
import com.niitblogsystem.service.ILeavewordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iLeavewordService")
public class LeavewordServiceImpl implements ILeavewordService{

    @Autowired
    private LeavewordPojoMapper leavewordPojoMapper;

    ////留言模块
    //添加留言
    @Override
    public ServerResponse<String> createLeaveword(String active, String passive, String leaveword) {
        //填充leavewordpojo
        LeavewordPojo leavewordPojo=new LeavewordPojo();
        leavewordPojo.setActive(active);
        leavewordPojo.setPassive(passive);
        leavewordPojo.setLeaveword(leaveword);
        //添加
        int resultColumn=leavewordPojoMapper.insertSelective(leavewordPojo);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }
    //查看留言墙
    @Override
    public ServerResponse<PageInfo> wallLeaveword(String username, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,"cretime desc");
        List<LeavewordPojo> leavewordPojos=leavewordPojoMapper.selectList(username);
        PageInfo pageInfo=new PageInfo(leavewordPojos);
        pageInfo.setList(leavewordPojos);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }
    //删除留言
    @Override
    public ServerResponse<String> delLeaveword(String username, long id) {
        int resultColumn=leavewordPojoMapper.deleteByIdAndUsername(id,username);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
}
