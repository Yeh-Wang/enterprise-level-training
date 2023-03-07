package com.dev.enter.service.impl;

import com.dev.enter.entity.MailInfo;
import com.dev.enter.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.annotation.Resource;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author : Yaxin-Wang
 * @date : 2023/3/7
 */
@Slf4j
@Component
public class SendMessageServiceImpl implements SendMessageService {

        @Resource
        private JavaMailSender javaMailSender;


        @Value(value = "${spring.mail.username}")
        private String emailFrom;


        @Override
        public void sendSimpleTextEmail(MailInfo mailInfo) {
            try {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                //发件人
                mailMessage.setFrom(emailFrom);
                //接收人
                mailMessage.setTo(mailInfo.getReceiver());
                //邮件主题
                mailMessage.setSubject(mailInfo.getSubject());
                //邮件抄送
                mailMessage.setCc(mailInfo.getCc());
                //邮件内容
                mailMessage.setText(mailInfo.getContent());
                //发送邮件
                javaMailSender.send(mailMessage);
            } catch (Exception e) {
                log.error("邮件发送失败:{}", e.getMessage());
            }
        }

//        @Override
//        public void sendHtmlEmail(MailInfo mailInfo,boolean html) {
//            try {
//                MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
//                //true 表示需要创建一个multipart message
//                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage);
//                //发件人
//                mimeMessageHelper.setFrom(emailFrom);
//                //接收人
//                mimeMessageHelper.setTo(mailInfo.getReceiver());
//                //邮件主题
//                mimeMessageHelper.setSubject(mailInfo.getSubject());
//                //邮件抄送
//                mimeMessageHelper.setCc(mailInfo.getCc());
//                //邮件内容
//                mimeMessageHelper.setText(mailInfo.getContent(), html);
//                javaMailSender.send(mimeMailMessage);
//            } catch (Exception e) {
//                log.error("邮件发送失败:{}", e.getMessage());
//            }
//        }
//
//
//        @Override
//        public void sendEnclosureEmail(MailInfo mailInfo) {
//            try {
//                MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
//                //true 表示需要创建一个multipart message
//                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
//                //发件人
//                mimeMessageHelper.setFrom(emailFrom);
//                //邮件接收人
//                mimeMessageHelper.setTo(mailInfo.getReceiver());
//                //邮件主题
//                mimeMessageHelper.setSubject(mailInfo.getSubject());
//                //邮件抄送
//                mimeMessageHelper.setCc(mailInfo.getCc());
//                //设置显示的发件时间
//                mimeMessageHelper.setSentDate(new Date());
//
//                MimeMultipart allMultipart = new MimeMultipart();
//
//                //创建代表邮件正文和附件的各个MimeBodyPart对象
//                MimeBodyPart contentPart = createContent(mailInfo.getContent(), mailInfo.getImageMap());
//                allMultipart.addBodyPart(contentPart);
//
//                //创建用于组合邮件正文和附件的MimeMultipart对象
//                for (int i = 0; i < mailInfo.getAttachFileNames().length; i++) {
//                    allMultipart.addBodyPart(createAttachment(mailInfo.getAttachFileNames()[i]));
//                }
//
//                //设置整个邮件内容为最终组合出的MimeMultipart对象
//                mimeMailMessage.setContent(allMultipart);
//                mimeMailMessage.saveChanges();
//
//                javaMailSender.send(mimeMailMessage);
//            } catch (Exception e) {
//                log.error("邮件发送失败:{}", e.getMessage());
//            }
//        }
//
//        /**
//         * 功能描述：邮件附件
//         * @param filename 文件路径
//         */
//        public MimeBodyPart createAttachment(String filename) throws Exception {
//            //创建保存附件的MimeBodyPart对象，并加入附件内容和相应的信息
//            MimeBodyPart attachPart = new MimeBodyPart();
//            FileDataSource fsd = new FileDataSource(filename);
//            attachPart.setDataHandler(new DataHandler(fsd));
//            attachPart.setFileName(fsd.getName());
//            return attachPart;
//        }
//
//        /**
//         * 功能描述：文本内容
//         * @param body html格式的文本内容
//         */
//        public MimeBodyPart createContent(String body) throws Exception {
//            //创建代表组合Mime消息的MimeMultipart对象，将该MimeMultipart对象保存到MimeBodyPart对象
//            MimeBodyPart contentPart = new MimeBodyPart();
//            MimeMultipart contentMultipart = new MimeMultipart("related");
//
//            //创建用于保存HTML正文的MimeBodyPart对象，并将它保存到MimeMultipart中
//            MimeBodyPart htmlBodyPart = new MimeBodyPart();
//            htmlBodyPart.setContent(body, "text/html;charset=UTF-8");
//            contentMultipart.addBodyPart(htmlBodyPart);
//
//            //将MimeMultipart对象保存到MimeBodyPart对象
//            contentPart.setContent(contentMultipart);
//            return contentPart;
//        }
//
//        /**
//         * 功能描述：文本内嵌图片
//         * @param body html格式的文本内容
//         * @param map 图片集合
//         */
//        public MimeBodyPart createContent(String body, Map<String, String> map) throws Exception {
//            //创建代表组合Mime消息的MimeMultipart对象，将该MimeMultipart对象保存到MimeBodyPart对象
//            MimeBodyPart contentPart = new MimeBodyPart();
//            MimeMultipart contentMultipart = new MimeMultipart("related");
//
//            //创建用于保存HTML正文的MimeBodyPart对象，并将它保存到MimeMultipart中
//            MimeBodyPart htmlBodyPart = new MimeBodyPart();
//            htmlBodyPart.setContent(body, "text/html;charset=UTF-8");
//            contentMultipart.addBodyPart(htmlBodyPart);
//
//            if (map != null && map.size() > 0) {
//                Set<Map.Entry<String, String>> set = map.entrySet();
//                for (Map.Entry<String, String> entry : set) {
//                    //创建用于保存图片的MimeBodyPart对象，并将它保存到MimeMultipart中
//                    MimeBodyPart gifBodyPart = new MimeBodyPart();
//                    FileDataSource fds = new FileDataSource(entry.getValue());//图片所在的目录的绝对路径
//
//                    gifBodyPart.setDataHandler(new DataHandler(fds));
//                    gifBodyPart.setContentID(entry.getKey());    //cid的值
//                    contentMultipart.addBodyPart(gifBodyPart);
//                }
//            }
//
//            //将MimeMultipart对象保存到MimeBodyPart对象
//            contentPart.setContent(contentMultipart);
//            return contentPart;
//        }
}
