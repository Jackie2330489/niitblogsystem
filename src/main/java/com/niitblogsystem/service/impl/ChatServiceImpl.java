package com.niitblogsystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niitblogsystem.common.MessageType;
import com.niitblogsystem.common.ServerResponse;
import com.niitblogsystem.dao.ChatPojoMapper;
import com.niitblogsystem.dao.MessagePojoMapper;
import com.niitblogsystem.pojo.ChatPojo;
import com.niitblogsystem.service.IChatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Justin on 2017/9/14.
 */
@Service("iChatService")
public class ChatServiceImpl implements IChatService{

    @Autowired
    private ChatPojoMapper chatPojoMapper;

    @Autowired
    private MessagePojoMapper messagePojoMapper;

    ////私信模块
    //发送私信
    @Override
    public ServerResponse<String> sendChat(String active, String passive, String msg) {
        //填充ChatPojo
        ChatPojo chatPojo=new ChatPojo();
        chatPojo.setActive(active);
        chatPojo.setPassive(passive);
        chatPojo.setMsg(msg);
        //添加到数据库
        int resultColumn=chatPojoMapper.insertSelective(chatPojo);
        if(resultColumn>0){
            //添加对方的未读消息
            messagePojoMapper.insertMessage(passive, MessageType.CHAT.getCode(),0);
            return ServerResponse.createBySuccessMessage("发送成功");
        }
        return ServerResponse.createByErrorMessage("发送失败");
    }
    //获取私信列表
    @Override
    public ServerResponse<PageInfo> listChat(String active, String passive, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize,"cretime asc");
        List<ChatPojo> chatPojos=null;
        if(StringUtils.isNotBlank(passive)){
            chatPojos=chatPojoMapper.selectList(active,passive);
        }else{
            chatPojos=chatPojoMapper.selectMyList(active);
            messagePojoMapper.readMessages(active,MessageType.CHAT.getCode());
        }
        PageInfo pageInfo=new PageInfo(chatPojos);
        pageInfo.setList(chatPojos);
        return ServerResponse.createBySuccess("获取成功",pageInfo);
    }
}
