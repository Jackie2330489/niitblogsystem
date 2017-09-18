package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.PostPojoMapper;
import com.niitblogsystem.pojo.PostPojo;
import com.niitblogsystem.service.IPostService;
import com.niitblogsystem.service.ITagService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.abbreviate;
import static org.apache.commons.lang3.StringUtils.split;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iPostService")
public class PostServiceImpl implements IPostService {

    @Autowired
    private PostPojoMapper postPojoMapper;

    @Autowired
    private ITagService iTagService;

    ////博文模块
    //发表博文
    @Override
    public ServerResponse<String> createPost(String author, String title, String body, int status, String tags) {
        //填充postpojo
        PostPojo postPojo=new PostPojo();
        postPojo.setAuthor(author);
        postPojo.setTitle(title);
        postPojo.setBody(body);
        postPojo.setStatus(status);
        int resultColumn=postPojoMapper.insertSelective(postPojo);
        if(resultColumn>0){
            //添加成功
            //对tags按,分组
            String[] tagsSplits=StringUtils.split(tags,',');
            //tags工具
            iTagService.handleTags(postPojo.getId(),tagsSplits);
            return ServerResponse.createBySuccessMessage("发表成功");
        }
        return ServerResponse.createByErrorMessage("发表失败");
    }
    //删除博文
    @Override
    public ServerResponse<String> delPost(String username, long postid) {
        int resultColumn=postPojoMapper.deleteByIdAndAuthor(username,postid);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
    //更新博文
    @Override
    public ServerResponse<String> updatePost(long postid, String title, String body, int status, String author) {
        PostPojo postPojo=postPojoMapper.selectByPrimaryKey(postid);
        //检查作者是否符合
        if(postPojo.getAuthor().equals(author)){
            //符合 填充postpojo 更新
            postPojo.setTitle(title);
            postPojo.setBody(body);
            postPojo.setStatus(status);
            postPojoMapper.updateByPrimaryKeySelective(postPojo);
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }
    //更新博文状态
    @Override
    public ServerResponse<String> updatePostStatus(String username, long id, int status) {
        int resultColumn=postPojoMapper.updatePostStatus(username,id,status);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }
    ////管理博文模块
    //删除博文
    @Override
    public ServerResponse<String> delPostRoot(long postid) {
        int resultColumn=postPojoMapper.deleteByPrimaryKey(postid);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("删除成功");
        }
        return ServerResponse.createByErrorMessage("删除失败");
    }
    //更新博文状态
    @Override
    public ServerResponse<String> updatePostStatusRoot(long postid, int status) {
        int resultColumn=postPojoMapper.updatePostStatusRoot(postid,status);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        return ServerResponse.createByErrorMessage("更新失败");
    }
    //查看博文
    @Override
    public ServerResponse<PostPojo> getPost(long id) {
        PostPojo postPojo=postPojoMapper.selectByPrimaryKey(id);
        if(postPojo==null){
            return ServerResponse.createByErrorMessage("找不到该博文");
        }
        return ServerResponse.createBySuccess("查看成功",postPojo);
    }
    //查看博文列表
    @Override
    public ServerResponse<PageInfo> getPostList(String author, int pageNum, int pageSize, String orderby) {
        PageHelper.startPage(pageNum,pageSize,orderby);
        List<PostPojo> postPojos=postPojoMapper.selectPostList(author);
        PageInfo pageInfo=new PageInfo(postPojos);
        pageInfo.setList(postPojos);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }
}
