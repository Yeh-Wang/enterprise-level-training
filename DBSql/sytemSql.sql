CREATE DATABASE stu_analysis_system CHARACTER SET utf8;

use stu_analysis_system;

create table student_info(
                             stu_id varchar(32) primary key ,
                             stu_name varchar(20),
                             age int,
                             sex varchar(4),
                             telephone varchar(11),
                             address varchar(50),
                             qq varchar(11),
                             permissions int,
                             learning_ability varchar(2),
                             express_ability varchar(2),
                             thinking_ability varchar(2),
                             execute_ability varchar(2)
);

create table question_source (
                                 id varchar(36) primary key ,
                                 content varchar(200),
                                 option_a varchar(50),
                                 option_b varchar(50),
                                 option_c varchar(50),
                                 option_d varchar(50),
                                 question_type varchar(10),
                                 score_a int,
                                 score_b int,
                                 score_c int,
                                 score_d int
);

create table administrator(
                              id varchar(36) primary key,
                              user_name varchar(50),
                              real_name varchar(50),
                              age int,
                              telephone varchar(11),
                              user_pwd varchar(20),
                              sexy varchar(4),
                              user_type int
);

create table audit_table(
                            id int primary key auto_increment,
                            applicant varchar(36) not null ,
                            auditor varchar(36) not null ,
                            reason_content varchar(100) not null ,
                            result varchar(20),
                            foreign key (applicant) references student_info(stu_id) on update cascade on delete cascade ,
                            foreign key (auditor) references administrator(id) on update cascade on delete cascade
);

create view stu_to_auditor as select
                                  audit_table.id,
                                  audit_table.reason_content,
                                  audit_table.result,
                                  student_info.stu_name as applicant,
                                  administrator.real_name as auditor
                              from audit_table
                                       left join administrator on administrator.id = audit_table.auditor
                                       left join student_info on student_info.stu_id = audit_table.applicant;

# select question_type as name,COUNT(*) as value from question_source group by question_type;
#
# select GROUP_CONCAT(JSON_OBJECT('name',name,'value',value)) from (select question_type as name,COUNT(*) as value from question_source group by question_type) as myTable;
#
# select question_type as name,COUNT(*) as value from question_source group by question_type;


# 完整sql(带数据)
create table student_info
(
    stu_id           varchar(36) not null
        primary key,
    stu_number       varchar(11) null,
    stu_name         varchar(20) null,
    age              int         null,
    sex              varchar(4)  null,
    telephone        varchar(11) null,
    address          varchar(50) null,
    qq               varchar(11) null,
    permissions      int         null,
    learning_ability varchar(2)  null,
    express_ability  varchar(2)  null,
    thinking_ability varchar(2)  null,
    execute_ability  varchar(2)  null
);

INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('72b54ca4-e23d-4c34-bb60-0d15940583ae', '35453', '王禹轩', 20, '女', '1354234', '北京市', '', 1, '良', '中', '优', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('7jrRd', '577', '小煜', 15, '女', '17070180703', '重庆市', '32455', 0, '良', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('7Kyye', '6564641', '吴思聪', 27, '男', '14721857612', '河南省', '77966', 0, '优', '优', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('87m', '76804995', '孙弘文', 23, '男', '15615445235', '山西省', '701470704', 0, '中', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('8d0eb8da-fc3e-49c9-afa0-9305ab1386bc', '46469', '闵大洪', 20, '男', '5555', '湖北省', '44967', 0, '良', '良', '良', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('8Ti', '961088', '唐煜城', 19, '女', '15057193086', '吉林省', '512', 0, '优', '中', '中', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('98f3557c-321b-4e56-8564-2db4c01aabbf', '632007', '闵小洪', 20, '女', '13983058286', '重庆市', '116248544', 1, '中', '良', '良', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('9NwU', '90309', '莫伟宸', 23, '女', '17877144146', '北京市', '3104', 0, '优', '中', '良', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('aaa11232', '123', '王亚新', 21, '男', '1231234', '河南省', '542342', 0, '优', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('amVK', '2', '胡致远', 28, '男', '17627021840', '上海市', '9443184626', 0, '优', '中', '良', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('b97c2783-c69e-4ba2-8d3a-d40738ced54f', '65454', '何佳蔚', 22, '女', '123', '重庆市/重庆市/潼南区', ' 343554', 0, '良', '优', '中', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('c3518a92-b17c-4789-b549-97df18c9ae27', '123456789', '叶寻', 33, '男', '11111111111', '北京市/北京市/东城区', ' 2123213123', 0, '优', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('cc11', '211231', '王五', 21, '男', '123123', '重庆市', '12312312', 0, '良', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('ccad1231', '6321234', '闵乙洪', 20, '男', '75645112', '重庆市', '168667', 1, '中', '中', '中', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('d58a1c18-0f2b-4ac4-bb25-ba92248cc3db', '5594', '杨小洹', 22, '男', '46616', '北京市/北京市/朝阳区', ' 161949', 0, '良', '中', '中', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('e94a189a-46fc-4d61-93c0-b9172d669377', '886', 'zjc', 21, '男', '12388688688', '上海市/上海市/浦东新区', '想Q就Q', 0, '中', '中', '中', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('fAv', '98975471', '钟凯瑞', 25, '男', '17894624668', '北京市', '26', 0, '优', '中', '优', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('fJ', '8043754397', '钱弘文', 26, '女', '15765169632', '上海市', '42', 0, '良', '优', '中', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('GOfK8', '7245682', '谢鹏涛', 28, '男', '17309679749', '江苏省', '1083595', 0, '优', '中', '优', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('gsIAs', '1741', '秦涛', 23, '男', '15950456996', '山西省', '76098713', 0, '良', '优', '良', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('Ih9cZ', '686', '廖涛', 28, '女', '15698256378', '湖北省', '1677', 0, '良', '中', '良', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('ikOd', '363520', '刘明辉', 13, '女', '15154438559', '江苏省', '23', 0, '良', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('IT8kZ', '777933', '萧晋鹏', 21, '女', '15135357074', '江苏省', '3', 0, '良', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('jIY', '4567373', '覃航', 16, '男', '18519329244', '吉林省', '68839', 0, '良', '良', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('K49', '40924349', '李思源', 11, '男', '17787110379', '广东省', '2', 0, '优', '优', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('KmpzH', '2272246', '刘致远', 17, '男', '18872862487', '广东省', '54445103', 0, '优', '优', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('kuK', '8280', '姜雨泽', 16, '男', '15985771266', '黑龙江省', '229', 0, '优', '优', '良', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('lA', '64239', '石烨磊', 24, '男', '17106730038', '福建省', '23', 0, '优', '良', '中', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('lbnCz', '410805435', '雷鑫鹏', 14, '男', '17644319258', '河南省', '50', 0, '良', '中', '优', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('Me', '28555854', '杨钰轩', 14, '女', '15753792981', '江苏省', '965', 0, '优', '中', '良', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('N1U', '1554442', '朱伟诚', 22, '男', '17165804219', '北京市', '52', 0, '良', '中', '优', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('NGJ', '3258654998', '赖晟睿', 27, '男', '15845268206', '江苏省', '135', 0, '优', '良', '优', '良');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('nM', '2132968106', '蒋鹏', 15, '男', '17707549409', '西藏省', '15074', 0, '优', '良', '优', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('O20I', '118780', '马煜祺', 19, '男', '17162972928', '广东省', '562', 0, '良', '优', '优', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('OLH', '96512', '姚凯瑞', 27, '女', '15581229354', '福建省', '1790', 1, '良', '良', '优', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('PRo', '72', '李晋鹏', 20, '男', '15714367359', '河北省', '2953005', 0, '良', '中', '中', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('py', '99', '石立辉', 19, '男', '17127447396', '海南省', '90', 0, '中', '良', '优', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('R1', '12519454', '罗智宸', 25, '女', '17179053810', '陕西省', '629300', 0, '优', '良', '中', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('sV9', '924', '韦明杰', 17, '男', '15372689062', '北京市', '601456460', 0, '中', '中', '良', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('VkW', '4', '许鑫磊', 19, '女', '15780188341', '湖北省', '6', 0, '良', '中', '中', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('VP', '8942045974', '蒋思源', 15, '男', '15932939117', '河北省', '3', 0, '中', '良', '优', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('VZh', '9', '杨远航', 17, '男', '17026232611', '河南省', '12827', 0, '良', '良', '中', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('wSeo', '71600735', '夏绍齐', 18, '男', '15697332494', '海南省', '32', 0, '良', '中', '良', '中');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('WX6W', '786318', '蒋瑾瑜', 18, '男', '18010625486', '新疆省', '2420', 0, '中', '良', '中', '优');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('zi', '4445028825', '丁昊焱', 17, '男', '17536576186', '重庆市', '2', 0, '中', '中', '良', '中');

create table administrator
(
    id        varchar(36) not null
        primary key,
    user_name varchar(50) null,
    real_name varchar(50) null,
    age       int         null,
    telephone varchar(11) null,
    user_pwd  varchar(20) null,
    sexy      varchar(4)  null,
    user_type int         null
);

INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('3acb25b7-851b-412f-a2e0-59109eba91e9', 'ltx123', '蓝天翔', 20, '123213', 'ltx123', '男', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('726bf63a-1fb1-45b8-bf7c-0e7616899308', 'zjc123', '曾嘉诚', 33, '123', 'zjc1234', '男', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('7d27d092-a00b-4443-8abf-71ecc3964ce8', 'myway', '杨洹', 22, '13514', 'yh123', '男', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('84037ace-5281-41ac-9b4a-5884ddae9a4d', 'nzy', '倪泽宇', 22, '', 'nzy123', '男', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('973309d4-3b23-4bed-a436-f4ceffdf1573', 'double', '闵二洪', 23, '1342321', 'myh123', '男', 2);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a0194bc1-0e02-43cb-989c-7fe82feb80c3', '123zjc', null, null, null, '123zjc', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a73137f0-9424-45bf-a5dd-61e6a1b3f05f', 'wjw', '王家伟', 60, '135145', 'wjw123', '男', 2);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a8d30961-85cf-4f6f-a2e6-e2eff4aece64', 'saddsa', null, null, null, '123321qwe', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a91cf0cb-ee3f-4b75-a8be-1079652f5888', 'zjc12345', '项羽', 123, '123', 'zjc123', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('bbe9f724-9d06-4de0-870c-c19ea4df60bd', 'zjc大笨蛋', null, null, null, 'zjczjczjc111', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('c4087e8e-e8a0-4c0e-a31c-5d24bb182719', 'miuseee', '增加成', null, null, 'zjc123', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('e13349d8-4aa7-4a9d-9ee6-ac8e37a7212c', 'yewang', '王叶', 22, '15654', 'wy123', '男', 1);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('fba70b5a-2709-4c81-ac30-4e603e397cb3', 'wuhu', '芜湖', null, null, 'wy123', null, 0);

create table audit_table
(
    id             int auto_increment
        primary key,
    applicant      varchar(36)  not null,
    auditor        varchar(36)  null,
    reason_content varchar(100) not null,
    result         varchar(20)  null,
    contact        varchar(50)  null,
    constraint audit_table_ibfk_1
        foreign key (applicant) references student_info (stu_id)
            on update cascade on delete cascade,
    constraint audit_table_ibfk_2
        foreign key (auditor) references administrator (id)
            on update cascade on delete cascade
);

create index applicant
    on audit_table (applicant);

create index auditor
    on audit_table (auditor);

INSERT INTO stu_analysis_system.audit_table (id, applicant, auditor, reason_content, result, contact) VALUES (3, '72b54ca4-e23d-4c34-bb60-0d15940583ae', '726bf63a-1fb1-45b8-bf7c-0e7616899308', '哈哈哈', '未通过', '827767408@qq.com');
INSERT INTO stu_analysis_system.audit_table (id, applicant, auditor, reason_content, result, contact) VALUES (9, '98f3557c-321b-4e56-8564-2db4c01aabbf', '726bf63a-1fb1-45b8-bf7c-0e7616899308', '我想改', '未通过', '827767408@qq.com');
INSERT INTO stu_analysis_system.audit_table (id, applicant, auditor, reason_content, result, contact) VALUES (16, 'c3518a92-b17c-4789-b549-97df18c9ae27', '3acb25b7-851b-412f-a2e0-59109eba91e9', '修改，我擦', '未通过', '1627082750@qq.com');

create table question_source
(
    id            varchar(36)  not null
        primary key,
    content       varchar(200) null,
    option_a      varchar(50)  null,
    option_b      varchar(50)  null,
    option_c      varchar(50)  null,
    option_d      varchar(50)  null,
    question_type varchar(10)  null,
    score_a       int          null,
    score_b       int          null,
    score_c       int          null,
    score_d       int          null
);

INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('11', '是否有拖延症', '没有', '一点', '很严重', '病入膏肓', '执行能力', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('111', '有怎样的自学能力', '老师讲和自己学的效率差不多甚至更快', '自学后完全能完成相关作业', '自学时候理不清头绪', '效率很低而且理解不了要点', '学习能力', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('1aa1a1aa1', '和陌生人主动说话的频率', '经常会', '偶尔会', '偶尔会', '不会', '表达能力', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('2', '提出一些社会生活问题', '有时', '经常', '很少', '从不', '思维能力', 2, 3, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('22', '难以独立开始做一件事情', '从不', '有时', '经常', '极少', '执行能力', 3, 1, 1, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('222', '能制定学习目标与计划', '完全可以', '不可以', '很少能够', '经常能够', '学习能力', 2, 1, 1, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('2222', '和别人合作时的交流效率', '很清晰的让别人知道自己的意思', '让别人听明白个大概', '让人听的懂一点', '效率极低', '表达能力', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('2417deae-23d2-1ee4-d219-2d430424f9ab', '对于之前学习的知识的掌握程度', '绝大部分都理解掌握', '大部分掌握', '只记得一小部分', '死记硬背', '学习能力', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('3', '擅长玩狼人杀类的游戏吗', '大手子', '小手子', '多半躺赢', '说什么都信', '思维能力', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('33', '闹钟响几次才会起床', '一次', '两次', '我的闹钟只叫室友', '最后被室友叫醒', '执行能力', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('333', '在学习上多久会遇到问题和多快解决', '很少遇到问题，在遇到问题时也很快解决', '很少遇到问题，但是解决问题速度慢', '经常遇到问题，解决问题速度一半', '较少遇到问题，但是解决问题速度很慢', '学习能力', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('3333', '同学激烈讨论问题时，你的态度', '没有兴趣', '只是倾听', '偶尔表达', '积极参与', '表达能力', 1, 1, 2, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('4', '在课堂上与老师，同学想法不同时，会表达自己的见解吗', '不会表达', '极少表达', '会表达，并与同学老师争论', '会表达，不会与同学老师争论', '思维能力', 1, 1, 2, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('44', '平时作业的完成时间', '发下来就马上开始做', '一有空就做', '最后一天赶', '最后一天晚上赶', '执行能力', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('4444', '参加演讲活动的频率', '有活动就会参加', '参加大部分活动', '偶尔参加', '从不参加', '表达能力', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('cccc1111', '是否能理解数学的理论', '能够独自且很快理解', '能够独自理解', '能够在一定的帮助下理解', '在一定的帮助下缓慢理解', '思维能力', 3, 2, 1, 1);

create definer = root@`%` view stu_to_auditor as
select `stu_analysis_system`.`audit_table`.`id`             AS `id`,
       `stu_analysis_system`.`audit_table`.`reason_content` AS `reason_content`,
       `stu_analysis_system`.`audit_table`.`result`         AS `result`,
       `stu_analysis_system`.`student_info`.`stu_name`      AS `applicant`,
       `stu_analysis_system`.`administrator`.`real_name`    AS `auditor`
from ((`stu_analysis_system`.`audit_table` left join `stu_analysis_system`.`administrator`
       on ((`stu_analysis_system`.`administrator`.`id` =
            `stu_analysis_system`.`audit_table`.`auditor`))) left join `stu_analysis_system`.`student_info`
      on ((`stu_analysis_system`.`student_info`.`stu_id` = `stu_analysis_system`.`audit_table`.`applicant`)));

INSERT INTO stu_analysis_system.stu_to_auditor (id, reason_content, result, applicant, auditor) VALUES (3, '哈哈哈', '未通过', '王禹轩', '曾嘉诚');
INSERT INTO stu_analysis_system.stu_to_auditor (id, reason_content, result, applicant, auditor) VALUES (9, '我想改', '未通过', '闵小洪', '曾嘉诚');
INSERT INTO stu_analysis_system.stu_to_auditor (id, reason_content, result, applicant, auditor) VALUES (16, '修改，我擦', '未通过', '叶寻', '蓝天翔');
