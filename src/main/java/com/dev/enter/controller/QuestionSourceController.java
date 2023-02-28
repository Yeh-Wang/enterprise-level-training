package com.dev.enter.controller;

import com.dev.enter.entity.QuestionSourceEntity;
import com.dev.enter.entity.Result;
import com.dev.enter.service.impl.QuestionSourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@RestController
@RequestMapping("/question-source-entity")
public class QuestionSourceController {

    private QuestionSourceServiceImpl questionSourceService;

    @Autowired
    public void setQuestionSourceService(QuestionSourceServiceImpl questionSourceService){
        this.questionSourceService=questionSourceService;
    }

    /**
     * 获取所有问题信息
     */
    @ResponseBody
    @GetMapping("/getAllQuestion")
    Result<List<QuestionSourceEntity>> getAllQuestion(){
        Result<List<QuestionSourceEntity>> result = new Result<>();
        List<QuestionSourceEntity> list = questionSourceService.getAllQuestion();
        if(list.size()!=0){
            result.setData(list);
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        }else{
            result.setData(list);
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }

    /**
     * 根据问题类型获取问题
     */
    @ResponseBody
    @GetMapping("/getQuestionByType/{type}")
    Result<List<QuestionSourceEntity>> getQuestionByType(@PathVariable String type){
        Result<List<QuestionSourceEntity>> result = new Result<>();
        List<QuestionSourceEntity> list = questionSourceService.getQuestionByType(type);
        if(list.size()!=0){
            result.setData(list);
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        }else{
            result.setData(list);
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }

    /**
     * 添加一个问题信息
     */
    @ResponseBody
    @PostMapping("/addQuestion")
    Result<String> addQuestion(@RequestBody QuestionSourceEntity questionSourceEntity){
        Result<String> result = new Result<>();
        String id = UUID.randomUUID().toString();
        questionSourceEntity.setId(id);
        if(questionSourceService.addQuestion(questionSourceEntity)==1){
            result.setData("Add successfully");
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        }else{
            result.setData("All failed");
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }

    /**
     * 更新一个问题信息
     */
    @ResponseBody
    @PostMapping("/updateQuestion")
    Result<String> updateQuestion(@RequestBody QuestionSourceEntity questionSourceEntity){
        Result<String> result = new Result<>();
        if(questionSourceService.updateQuestion(questionSourceEntity)==1){
            result.setData("Update successfully");
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        }else{
            result.setData("Update failed");
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }

    /**
     * 删除一个问题信息通过编号
     */
    @ResponseBody
    @PostMapping("/deleteQuestionById/{id}")
    Result<String> deleteQuestionById(@PathVariable int id){
        Result<String> result = new Result<>();
        if(questionSourceService.deleteQuestionById(id)==1){
            result.setData("Delete successfully");
            result.setCode(200);
            result.setMessage("OK");
            result.setStatus(true);
        }else{
            result.setData("Delete failed");
            result.setCode(404);
            result.setMessage("fail");
            result.setStatus(false);
        }
        return result;
    }
}
