package com.niitblogsystem.service;

import java.util.List;

/**
 * Created by Justin on 2017/9/15.
 */
public interface ITagService {

    int handleTags(long postid, List<String> tags);

}
