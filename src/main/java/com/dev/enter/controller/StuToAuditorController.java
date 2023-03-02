package com.dev.enter.controller;

import com.dev.enter.entity.Result;
import com.dev.enter.entity.StuToAuditorEntity;
import com.dev.enter.mapper.StuToAuditorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : Yaxin-Wang
 * @date : 2023/3/2
 */
@RestController
@RequestMapping("/stu-to-auditor-entity")
public class StuToAuditorController {

    private StuToAuditorMapper stuToAuditorMapper;

    @Autowired
    public void setStuToAuditorMapper(StuToAuditorMapper stuToAuditorMapper){
        this.stuToAuditorMapper=stuToAuditorMapper;
    }

    /**
     * 获取所有申请表内信息
     */
    @ResponseBody
    @GetMapping("/getAllAuditorInfo")
    public Result<List<StuToAuditorEntity>> getAllAuditorInfo(){
        Result<List<StuToAuditorEntity>> result = new Result<>();
        List<StuToAuditorEntity> list = stuToAuditorMapper.selectList(null);
        if (list.size() != 0) {
            result.setData(list);
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        } else {
            result.setData(list);
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }
}
