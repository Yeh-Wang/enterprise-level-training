package com.dev.enter;

import com.dev.enter.mapper.AdministratorMapper;
import com.dev.enter.mapper.QuestionSourceMapper;
import com.dev.enter.service.impl.QuestionSourceServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.test.context.SpringBootTest;

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

    @Test
    void contextLoads() {
    }

    @Test
    void uuid() throws JSONException {
//        System.out.println(questionSourceMa);

    }

}
