package com.dev.enter;

import com.dev.enter.mapper.AdministratorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class EnterLevelSystemApplicationTests {

    @Autowired
    AdministratorMapper administratorMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void uuid(){
        for (int i=0;i<5;i++){
            UUID uuid = UUID.randomUUID();
            System.out.println(uuid);
        }
    }

}
