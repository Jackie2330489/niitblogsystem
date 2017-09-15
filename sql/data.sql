#添加假数据
USE niitblog;
#添加管理员
INSERT INTO bsuser(username,email,password) VALUES('root','root@niit.com','root');
#添加用户
INSERT INTO bsuser(username,email,password) VALUES
('Apple','apple@niit.com','apple'),
('Banana','banana@niit.com','banana'),
('Cat','cat@niit.com','cat'),
('Doctor','doctor@niit.com','doctor'),
('Egg','egg@niit.com','egg');
#添加博文
INSERT INTO bspost(author,title,body,status) VALUES
('Apple','One Apple One Day','Doctor keep me away.',1),
('Apple','Two Apples Two Days','Doctor keep me away.',1),
('Apple','Three Apples Three Days','Doctor keep me away.',1),
('Apple','Four Apples Four Days','Doctor keep me away.',1),
('Apple','Five Apples Five Days','Doctor keep me away.',1),
('Apple','Six Apples Six Days','Doctor keep me away.',1),
('Apple','No Apples No Days','Doctor keep me away.',0),
('Apple','Noo Apples Noo Days','Doctor keep me away.',0),
('Apple','Nooo Apples Nooo Days','Doctor keep me away.',0);
#添加评论
INSERT INTO bscomment(postid,active,passive,comment) VALUES
(1,'Banana','Apple','Good Post'),
(1,'Apple','Banana','Thx'),
(1,'Cat','Banana','是的');
#添加留言
INSERT INTO bsleaveword(active,passive,leaveword) VALUES
('Banana','Apple','Hello Apple.'),
('Apple','Banana','Hello back.'),
('Cat','Banana','踩踩。');
#添加私信
INSERT INTO bschat(active,passive,msg) VALUES
('Banana','Apple','Hello Apple.'),
('Apple','Banana','Hello back.'),
('Cat','Banana','踩踩。');
#添加点赞
INSERT INTO bslike(active,passive) VALUES
('Banana','Apple'),
('Cat','Apple');
INSERT INTO bslike(active,passive,postid) VALUES
('Banana','Apple',1);
#添加标签
INSERT INTO bstag(tagname,posts) VALUES
('Good Apples'),
('No Apples');
#添加标签博文关系
INSERT INTO bstag2post(postid,tagid) VALUES
(1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,2),(8,2),(9,2);
#添加关注
INSERT INTO bsfollow(active,passive) VALUES
('Banana','Apple'),
('Cat','Apple');
#添加消息
INSERT INTO bsmessage(username,msgtype,status) VALUES
('Banana',1,0),('Banana',1,1),('Banana',2,0),
('Apple',2,1),('Apple',3,0),('Apple',3,1),('Apple',4,0),('Apple',4,1);
#添加敏感信息
INSERT INTO bssensitive(word) VALUES ('fuck'),('妈的');