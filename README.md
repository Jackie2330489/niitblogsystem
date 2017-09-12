##Niit Blog System
前台框架：Bootstrap

后台框架：SpringMVC,Spring,Mybatis,MySQL
####需求
* 访客：阅读博文，评论博文，对博主留言，关注博主，私信，点赞，打赏
* 博主：发表、编辑、删除、浏览博文，分类归档博文，评论管理，留言管理，个人信息维护，对其他博主的关注
* 管理员：用户管理、博文管理，敏感信息过滤
####非功能性需求
* 预防SQL注入
* 预防XSS攻击
####数据库设计
![](pic/database.jpg)
####模块
* 注册
* 登录
* 博文
* 评论
* 留言
* 关注
* 私信
* 点赞
* 打赏
* 个人信息维护
* 用户管理
* 敏感信息管理
####接口
#####注册
1.检查用户名是否有效或已存在

/user/check_username  #get

2.检查邮箱是否有效或已存在

/user/check_email   #get

3.发邮箱验证码

/user/register_send_email_vericode    #post

4.验证验证码

/user/register_veri_email_vericode #post

4.注册用户

/user/register  #post
#####登录
1.登录

/user/login #post

2.忘记密码时发邮箱验证码

/user/login_send_email_vericode #post

3.验证验证码登录

/user/login_veri_email_vericode #post

#####博文

1.阅读博文

/post/? #get

2.