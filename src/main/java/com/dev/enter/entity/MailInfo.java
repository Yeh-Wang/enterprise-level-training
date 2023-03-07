package com.dev.enter.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author : Yaxin-Wang
 * @date : 2023/3/7
 */
@Data
public  class MailInfo {
    // 邮件接收人
    private String[] receiver;
    // 邮件主题
    private String subject;
    // 邮件的文本内容
    private String content;
    // 抄送人
    private String[] cc;
    // 邮件附件的文件名
    private String[] attachFileNames;
    // 邮件内容内嵌图片
    private Map<String,String> imageMap;
}

