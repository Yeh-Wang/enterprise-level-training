package com.dev.enter.service;

import com.dev.enter.entity.MailInfo;

/**
 * @author : Yaxin-Wang
 * @date : 2023/3/7
 */
public interface SendMessageService {

    /**
     * 功能描述：发送text邮件
     *
     * @param mailInfo 邮件信息
     */
    void sendSimpleTextEmail(MailInfo mailInfo);

//    /**
//     * 功能描述：发送html邮件
//     *
//     * @param mailInfo 邮件信息
//     * @param html     是否是html邮件
//     */
//    void sendHtmlEmail(MailInfo mailInfo, boolean html);
//
//    /**
//     * 功能描述：发送文本内容（内嵌图片）且带附件的html邮件
//     *
//     * @param mailInfo 邮件信息
//     */
//    void sendEnclosureEmail(MailInfo mailInfo);
}
