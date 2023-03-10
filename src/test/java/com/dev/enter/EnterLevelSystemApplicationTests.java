package com.dev.enter;

import com.dev.enter.entity.MailInfo;
import com.dev.enter.mapper.AdministratorMapper;
import com.dev.enter.mapper.QuestionSourceMapper;
import com.dev.enter.service.impl.AuditTableServiceImpl;
import com.dev.enter.service.impl.QuestionSourceServiceImpl;
import com.dev.enter.service.impl.SendMessageServiceImpl;
import com.dev.enter.service.impl.StudentInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

import java.util.UUID;

import static com.alibaba.druid.util.FnvHash.Constants.GSON;

@SpringBootTest
class EnterLevelSystemApplicationTests {

    @Autowired
    AdministratorMapper administratorMapper;

    @Autowired
    QuestionSourceMapper questionSourceMapper;

    @Autowired
    QuestionSourceServiceImpl questionSourceService;

    @Autowired
    StudentInfoServiceImpl studentInfoService;

    @Autowired
    SendMessageServiceImpl sendMessageService;

    @Autowired
    AuditTableServiceImpl auditTableService;

    @Test
    void contextLoads() {
    }

    @Test
    void test(){
//        System.out.println(studentInfoService.getFemaleProp());
//        System.out.println(studentInfoService.getMaleProp());
//        MailInfo mailInfo = new MailInfo();
//        mailInfo.setReceiver(new String[]{"1016248544@qq.com"});
//        mailInfo.setSubject("修改通知");
//        mailInfo.setContent("http://1.15.62.89/update");
//        sendMessageService.sendSimpleTextEmail(mailInfo);
//        auditTableService.changePermissionById(9,"3acb25b7-851b-412f-a2e0-59109eba91e9");
//    String version = SpringVersion.getVersion();
//    System.out.println(version);
    }

}
