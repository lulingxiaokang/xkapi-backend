-- 创建库
create database if not exists xkapi;

-- 切换库
use xkapi;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) comment '用户';

-- 帖子表
create table if not exists post
(
    id            bigint auto_increment comment 'id' primary key,
    age           int comment '年龄',
    gender        tinyint  default 0                 not null comment '性别（0-男, 1-女）',
    education     varchar(512)                       null comment '学历',
    place         varchar(512)                       null comment '地点',
    job           varchar(512)                       null comment '职业',
    contact       varchar(512)                       null comment '联系方式',
    loveExp       varchar(512)                       null comment '感情经历',
    content       text                               null comment '内容（个人介绍）',
    photo         varchar(1024)                      null comment '照片地址',
    reviewStatus  int      default 0                 not null comment '状态（0-待审核, 1-通过, 2-拒绝）',
    reviewMessage varchar(512)                       null comment '审核信息',
    viewNum       int                                not null default 0 comment '浏览数',
    thumbNum      int                                not null default 0 comment '点赞数',
    userId        bigint                             not null comment '创建用户 id',
    createTime    datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime    datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete      tinyint  default 0                 not null comment '是否删除'
) comment '帖子';

-- 接口信息
create table if not exists xkapi.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '名称',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `requestParams` text not null comment '请求参数',
    `requestHeader` text null comment '请求头',
    `responseHeader` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0-关闭，1-开启）',
    `method` varchar(256) not null comment '请求类型',
    `userId` bigint not null comment '创建人',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息';

-- 用户调用接口关系表
create table if not exists xkapi.`user_interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `userId` bigint not null comment '调用用户 id',
    `interfaceInfoId` bigint not null comment '接口 id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '0-正常，1-禁用',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户调用接口关系';

insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('许擎宇', '薛聪健', 'String', 'www.cary-king.net', '潘博涛', '谭聪健', 0, '石炫明', 9500534531);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('陆弘文', '白志强', 'String', 'www.leslee-kuhn.net', '潘懿轩', '马鸿涛', 0, '陈峻熙', 3982575846);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('毛建辉', '罗文', 'String', 'www.rosaria-kilback.io', '冯子默', '彭哲瀚', 0, '赵远航', 121776355);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('彭雨泽', '蔡煜祺', 'String', 'www.norris-bergstrom.biz', '董思源', '田晓博', 0, '潘擎宇', 740);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('傅志强', '陈梓晨', 'String', 'www.jordan-reinger.com', '金志强', '熊锦程', 0, '邓睿渊', 35542559);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('吕黎昕', '孔越彬', 'String', 'www.fe-okon.info', '万伟宸', '林昊然', 0, '孟荣轩', 1445);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('夏雪松', '许子骞', 'String', 'www.lashawna-legros.co', '蔡昊然', '胡鹏涛', 0, '钟立辉', 34075514);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('严钰轩', '阎志泽', 'String', 'www.kay-funk.biz', '莫皓轩', '郭黎昕', 0, '龚天宇', 70956);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('萧嘉懿', '曹熠彤', 'String', 'www.margarette-lindgren.biz', '田泽洋', '邓睿渊', 0, '梁志强', 98);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('杜驰', '冯思源', 'String', 'www.vashti-auer.org', '黎健柏', '武博文', 0, '李伟宸', 9);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('史金鑫', '蔡鹏涛', 'String', 'www.diann-keebler.org', '徐烨霖', '阎建辉', 0, '李烨伟', 125);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('林炫明', '贾旭尧', 'String', 'www.dotty-kuvalis.io', '梁雨泽', '龙伟泽', 0, '许智渊', 79998);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('何钰轩', '赖智宸', 'String', 'www.andy-adams.net', '崔思淼', '白鸿煊', 0, '邵振家', 7167482751);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('魏志强', '于立诚', 'String', 'www.ione-aufderhar.biz', '朱懿轩', '万智渊', 0, '唐昊强', 741098);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('严君浩', '金胤祥', 'String', 'www.duane-boyle.org', '雷昊焱', '侯思聪', 0, '郝思', 580514);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('姚皓轩', '金鹏', 'String', 'www.lyda-klein.biz', '杜昊强', '邵志泽', 0, '冯鸿涛', 6546);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('廖驰', '沈泽洋', 'String', 'www.consuelo-sipes.info', '彭昊然', '邓耀杰', 0, '周彬', 7761037);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('赖智渊', '邓志泽', 'String', 'www.emerson-mann.co', '熊明哲', '贺哲瀚', 0, '田鹏', 381422);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('许涛', '陆致远', 'String', 'www.vella-ankunding.name', '贾哲瀚', '莫昊焱', 0, '袁越彬', 4218096);
insert into xkapi.`interface_info` (`name`, `description`, `requestParams`, `url`, `requestHeader`, `responseHeader`, `status`, `method`, `userId`) values ('吕峻熙', '沈鹏飞', 'String', 'www.shari-reichel.org', '郭鸿煊', '覃烨霖', 0, '熊黎昕', 493);



