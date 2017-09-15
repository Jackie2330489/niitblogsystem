package com.niitblogsystem.service.impl;

import com.niitblogsystem.dao.TagPojoMapper;
import com.niitblogsystem.pojo.TagPojo;
import com.niitblogsystem.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Justin on 2017/9/15.
 */
@Service("iTagService")
public class TagServiceImpl implements ITagService {

    @Autowired
    private TagPojoMapper tagPojoMapper;

    @Override
    public int handleTags(long postid, List<String> tags) {
        //受影响行数
        int lines=0;
        for(String tag:tags){
            //查找tag是否存在 返回tagid
            Integer tagid=tagPojoMapper.selectId(tag);
            if(null==tagid){
                //若不存在 添加新tag
                //填充tag
                TagPojo tagPojo=new TagPojo();
                tagPojo.setTagname(tag);
                tagid=tagPojoMapper.insertSelective(tagPojo);
            }
            lines+=tagPojoMapper.insertTag2Post(postid,tagid);
        }
        return lines;
    }
}
