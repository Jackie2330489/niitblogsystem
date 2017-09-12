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
####用户模块
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
####管理员模块
* 用户管理
* 博文管理
* 敏感信息管理
####接口
#####注册
1. 检查用户名是否有效或已存在 #get

/user/check_valid  (request:str,type)

2. 发邮箱验证码   #post

/user/send_email_vericode  (request:email)

3. 校验验证码    #post

/user/veri_email_vericode  (request:vericode)

4. 注册用户 #post

/user/register (request:UserPojo)
#####登录
1. 登录 #post

/user/login (request:username,password)

2. 登出 #get

/user/logout