package com.niitblogsystem.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by Justin on 2017/9/12.
 */
public class EmailHelper {
    public static int sendEmailVerCode(String targetEmail) throws MessagingException{

        //email的属性设置
        Properties props=new Properties();
        props.setProperty("mail.debug","true");
        props.setProperty("mail.stmp.auth","true");
        props.setProperty("mail.host","smtp.163.com");
        props.setProperty("mail.transport.protocol","smtp");
        Session session=Session.getInstance(props);

        //邮件内容设置
        Message msg=new MimeMessage(session);
        msg.setSubject("Niit BlogSystem邮箱验证码");
        int code=(int)(Math.random()*9000+1000);
        msg.setText("验证码是："+code);
        msg.setFrom(new InternetAddress("qd2017hst@163.com"));

        //连接自己的邮箱
        Transport transport=session.getTransport();
        transport.connect("qd2017hst","hst0316");

        //目标邮箱
        transport.sendMessage(msg,new Address[]{new InternetAddress(targetEmail)});
        transport.close();
        return code;
    }
}
