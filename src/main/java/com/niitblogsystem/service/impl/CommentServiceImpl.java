package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.CommentPojoMapper;
import com.niitblogsystem.pojo.CommentPojo;
import com.niitblogsystem.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iCommentService")
public class CommentServiceImpl implements ICommentService{

    @Autowired
    private CommentPojoMapper commentPojoMapper;

    ////评论模块
    //添加评论
    @Override
    public ServerResponse<String> createComment(long postid, String active, String passive, String comment) {
        //填充CommentPojo
        CommentPojo commentPojo=new CommentPojo();
        commentPojo.setPostid(postid);
        commentPojo.setActive(active);
        commentPojo.setPassive(passive);
        commentPojo.setComment(comment);
        //添加到数据库
        int resultColumn=commentPojoMapper.insertSelective(commentPojo);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("添加成功");
        }
        return ServerResponse.createByErrorMessage("添加失败");
    }
    //删除评论
    @Override
    public ServerResponse<String> delComment(long id, String active) {
        //更新
        int resultColumn=commentPojoMapper.deleteByIdAndUsername(id,active);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
    //查看博文评论
    @Override
    public ServerResponse<PageInfo> postComment(long postid, int pageNum, int pageSize) {
        //使用降序
        PageHelper.startPage(pageNum,pageSize,"cretime desc");
        List<CommentPojo> commentPojos=commentPojoMapper.postComments(postid);
        PageInfo pageInfo=new PageInfo(commentPojos);
        pageInfo.setList(commentPojos);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }

    @Override
    public ServerResponse<PageInfo> userComment(String active, int pageNum, int pageSize) {
        //使用降序
        PageHelper.startPage(pageNum,pageSize,"cretime desc");
        List<CommentPojo> commentPojos=commentPojoMapper.userComments(active);
        PageInfo pageInfo=new PageInfo(commentPojos);
        pageInfo.setList(commentPojos);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }
}
