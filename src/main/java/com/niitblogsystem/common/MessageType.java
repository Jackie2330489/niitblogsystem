package com.niitblogsystem.common;

/**
 * Created by Justin on 2017/9/14.
 */
public enum MessageType {
    COMMENT(1,"COMMENT"),
    LEAVEWORD(2,"LEAVEWORD"),
    CHAT(3,"CHAT"),
    LIKE(4,"LIKE"),
    SYSTEM(5,"SYSTEM");

    private final int code;
    private final String desc;

    MessageType(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
