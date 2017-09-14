package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.LikePojoMapper;
import com.niitblogsystem.pojo.LikePojo;
import com.niitblogsystem.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iLikeService")
public class LikeServiceImpl implements ILikeService{

    @Autowired
    private LikePojoMapper likePojoMapper;

    ////点赞模块
    //点赞
    @Override
    public ServerResponse<String> createLike(String active, String passive, long postid) {
        //填充likepojo
        LikePojo likePojo=new LikePojo();
        likePojo.setActive(active);
        likePojo.setPassive(passive);
        if(postid!=0){
            //检查是否为对文章点赞
            likePojo.setPostid(postid);
        }
        int resultColumn=likePojoMapper.insertSelective(likePojo);
        if(resultColumn>0){
            return ServerResponse.createBySuccessMessage("点赞成功");
        }
        return ServerResponse.createByErrorMessage("点赞失败");
    }
    //查看点赞
    @Override
    public ServerResponse<PageInfo> listLike(String username, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,"cretime desc");
        //收获点赞
        List<LikePojo> likePojos=likePojoMapper.selectList(username);
        PageInfo pageInfo=new PageInfo(likePojos);
        pageInfo.setList(likePojos);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }
}
