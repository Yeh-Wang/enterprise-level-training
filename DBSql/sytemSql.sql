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


# ??????sql(?????????)
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

INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('72b54ca4-e23d-4c34-bb60-0d15940583ae', '35453', '?????????', 20, '???', '1354234', '?????????', '', 1, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('7jrRd', '577', '??????', 15, '???', '17070180703', '?????????', '32455', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('7Kyye', '6564641', '?????????', 27, '???', '14721857612', '?????????', '77966', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('87m', '76804995', '?????????', 23, '???', '15615445235', '?????????', '701470704', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('8d0eb8da-fc3e-49c9-afa0-9305ab1386bc', '46469', '?????????', 20, '???', '5555', '?????????', '44967', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('8Ti', '961088', '?????????', 19, '???', '15057193086', '?????????', '512', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('98f3557c-321b-4e56-8564-2db4c01aabbf', '632007', '?????????', 20, '???', '13983058286', '?????????', '116248544', 1, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('9NwU', '90309', '?????????', 23, '???', '17877144146', '?????????', '3104', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('aaa11232', '123', '?????????', 21, '???', '1231234', '?????????', '542342', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('amVK', '2', '?????????', 28, '???', '17627021840', '?????????', '9443184626', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('b97c2783-c69e-4ba2-8d3a-d40738ced54f', '65454', '?????????', 22, '???', '123', '?????????/?????????/?????????', ' 343554', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('c3518a92-b17c-4789-b549-97df18c9ae27', '123456789', '??????', 33, '???', '11111111111', '?????????/?????????/?????????', ' 2123213123', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('cc11', '211231', '??????', 21, '???', '123123', '?????????', '12312312', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('ccad1231', '6321234', '?????????', 20, '???', '75645112', '?????????', '168667', 1, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('d58a1c18-0f2b-4ac4-bb25-ba92248cc3db', '5594', '?????????', 22, '???', '46616', '?????????/?????????/?????????', ' 161949', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('e94a189a-46fc-4d61-93c0-b9172d669377', '886', 'zjc', 21, '???', '12388688688', '?????????/?????????/????????????', '???Q???Q', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('fAv', '98975471', '?????????', 25, '???', '17894624668', '?????????', '26', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('fJ', '8043754397', '?????????', 26, '???', '15765169632', '?????????', '42', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('GOfK8', '7245682', '?????????', 28, '???', '17309679749', '?????????', '1083595', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('gsIAs', '1741', '??????', 23, '???', '15950456996', '?????????', '76098713', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('Ih9cZ', '686', '??????', 28, '???', '15698256378', '?????????', '1677', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('ikOd', '363520', '?????????', 13, '???', '15154438559', '?????????', '23', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('IT8kZ', '777933', '?????????', 21, '???', '15135357074', '?????????', '3', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('jIY', '4567373', '??????', 16, '???', '18519329244', '?????????', '68839', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('K49', '40924349', '?????????', 11, '???', '17787110379', '?????????', '2', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('KmpzH', '2272246', '?????????', 17, '???', '18872862487', '?????????', '54445103', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('kuK', '8280', '?????????', 16, '???', '15985771266', '????????????', '229', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('lA', '64239', '?????????', 24, '???', '17106730038', '?????????', '23', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('lbnCz', '410805435', '?????????', 14, '???', '17644319258', '?????????', '50', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('Me', '28555854', '?????????', 14, '???', '15753792981', '?????????', '965', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('N1U', '1554442', '?????????', 22, '???', '17165804219', '?????????', '52', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('NGJ', '3258654998', '?????????', 27, '???', '15845268206', '?????????', '135', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('nM', '2132968106', '??????', 15, '???', '17707549409', '?????????', '15074', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('O20I', '118780', '?????????', 19, '???', '17162972928', '?????????', '562', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('OLH', '96512', '?????????', 27, '???', '15581229354', '?????????', '1790', 1, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('PRo', '72', '?????????', 20, '???', '15714367359', '?????????', '2953005', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('py', '99', '?????????', 19, '???', '17127447396', '?????????', '90', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('R1', '12519454', '?????????', 25, '???', '17179053810', '?????????', '629300', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('sV9', '924', '?????????', 17, '???', '15372689062', '?????????', '601456460', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('VkW', '4', '?????????', 19, '???', '15780188341', '?????????', '6', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('VP', '8942045974', '?????????', 15, '???', '15932939117', '?????????', '3', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('VZh', '9', '?????????', 17, '???', '17026232611', '?????????', '12827', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('wSeo', '71600735', '?????????', 18, '???', '15697332494', '?????????', '32', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('WX6W', '786318', '?????????', 18, '???', '18010625486', '?????????', '2420', 0, '???', '???', '???', '???');
INSERT INTO stu_analysis_system.student_info (stu_id, stu_number, stu_name, age, sex, telephone, address, qq, permissions, learning_ability, express_ability, thinking_ability, execute_ability) VALUES ('zi', '4445028825', '?????????', 17, '???', '17536576186', '?????????', '2', 0, '???', '???', '???', '???');

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

INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('3acb25b7-851b-412f-a2e0-59109eba91e9', 'ltx123', '?????????', 20, '123213', 'ltx123', '???', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('726bf63a-1fb1-45b8-bf7c-0e7616899308', 'zjc123', '?????????', 33, '123', 'zjc1234', '???', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('7d27d092-a00b-4443-8abf-71ecc3964ce8', 'myway', '??????', 22, '13514', 'yh123', '???', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('84037ace-5281-41ac-9b4a-5884ddae9a4d', 'nzy', '?????????', 22, '', 'nzy123', '???', 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('973309d4-3b23-4bed-a436-f4ceffdf1573', 'double', '?????????', 23, '1342321', 'myh123', '???', 2);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a0194bc1-0e02-43cb-989c-7fe82feb80c3', '123zjc', null, null, null, '123zjc', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a73137f0-9424-45bf-a5dd-61e6a1b3f05f', 'wjw', '?????????', 60, '135145', 'wjw123', '???', 2);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a8d30961-85cf-4f6f-a2e6-e2eff4aece64', 'saddsa', null, null, null, '123321qwe', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('a91cf0cb-ee3f-4b75-a8be-1079652f5888', 'zjc12345', '??????', 123, '123', 'zjc123', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('bbe9f724-9d06-4de0-870c-c19ea4df60bd', 'zjc?????????', null, null, null, 'zjczjczjc111', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('c4087e8e-e8a0-4c0e-a31c-5d24bb182719', 'miuseee', '?????????', null, null, 'zjc123', null, 0);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('e13349d8-4aa7-4a9d-9ee6-ac8e37a7212c', 'yewang', '??????', 22, '15654', 'wy123', '???', 1);
INSERT INTO stu_analysis_system.administrator (id, user_name, real_name, age, telephone, user_pwd, sexy, user_type) VALUES ('fba70b5a-2709-4c81-ac30-4e603e397cb3', 'wuhu', '??????', null, null, 'wy123', null, 0);

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

INSERT INTO stu_analysis_system.audit_table (id, applicant, auditor, reason_content, result, contact) VALUES (3, '72b54ca4-e23d-4c34-bb60-0d15940583ae', '726bf63a-1fb1-45b8-bf7c-0e7616899308', '?????????', '?????????', '827767408@qq.com');
INSERT INTO stu_analysis_system.audit_table (id, applicant, auditor, reason_content, result, contact) VALUES (9, '98f3557c-321b-4e56-8564-2db4c01aabbf', '726bf63a-1fb1-45b8-bf7c-0e7616899308', '?????????', '?????????', '827767408@qq.com');
INSERT INTO stu_analysis_system.audit_table (id, applicant, auditor, reason_content, result, contact) VALUES (16, 'c3518a92-b17c-4789-b549-97df18c9ae27', '3acb25b7-851b-412f-a2e0-59109eba91e9', '???????????????', '?????????', '1627082750@qq.com');

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

INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('11', '??????????????????', '??????', '??????', '?????????', '????????????', '????????????', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('111', '????????????????????????', '???????????????????????????????????????????????????', '????????????????????????????????????', '???????????????????????????', '????????????????????????????????????', '????????????', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('1aa1a1aa1', '?????????????????????????????????', '?????????', '?????????', '?????????', '??????', '????????????', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('2', '??????????????????????????????', '??????', '??????', '??????', '??????', '????????????', 2, 3, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('22', '?????????????????????????????????', '??????', '??????', '??????', '??????', '????????????', 3, 1, 1, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('222', '??????????????????????????????', '????????????', '?????????', '????????????', '????????????', '????????????', 2, 1, 1, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('2222', '?????????????????????????????????', '??????????????????????????????????????????', '???????????????????????????', '?????????????????????', '????????????', '????????????', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('2417deae-23d2-1ee4-d219-2d430424f9ab', '??????????????????????????????????????????', '???????????????????????????', '???????????????', '?????????????????????', '????????????', '????????????', 3, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('3', '?????????????????????????????????', '?????????', '?????????', '????????????', '???????????????', '????????????', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('33', '???????????????????????????', '??????', '??????', '????????????????????????', '?????????????????????', '????????????', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('333', '????????????????????????????????????????????????', '??????????????????????????????????????????????????????', '????????????????????????????????????????????????', '?????????????????????????????????????????????', '???????????????????????????????????????????????????', '????????????', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('3333', '??????????????????????????????????????????', '????????????', '????????????', '????????????', '????????????', '????????????', 1, 1, 2, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('4', '???????????????????????????????????????????????????????????????????????????', '????????????', '????????????', '????????????????????????????????????', '???????????????????????????????????????', '????????????', 1, 1, 2, 2);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('44', '???????????????????????????', '???????????????????????????', '???????????????', '???????????????', '?????????????????????', '????????????', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('4444', '???????????????????????????', '?????????????????????', '?????????????????????', '????????????', '????????????', '????????????', 2, 2, 1, 1);
INSERT INTO stu_analysis_system.question_source (id, content, option_a, option_b, option_c, option_d, question_type, score_a, score_b, score_c, score_d) VALUES ('cccc1111', '??????????????????????????????', '???????????????????????????', '??????????????????', '?????????????????????????????????', '?????????????????????????????????', '????????????', 3, 2, 1, 1);

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

INSERT INTO stu_analysis_system.stu_to_auditor (id, reason_content, result, applicant, auditor) VALUES (3, '?????????', '?????????', '?????????', '?????????');
INSERT INTO stu_analysis_system.stu_to_auditor (id, reason_content, result, applicant, auditor) VALUES (9, '?????????', '?????????', '?????????', '?????????');
INSERT INTO stu_analysis_system.stu_to_auditor (id, reason_content, result, applicant, auditor) VALUES (16, '???????????????', '?????????', '??????', '?????????');
