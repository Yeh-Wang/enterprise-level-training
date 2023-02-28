package com.dev.enter.controller;

import com.dev.enter.entity.QuestionSourceEntity;
import com.dev.enter.entity.Result;
import com.dev.enter.service.impl.QuestionSourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    List<QuestionSourceEntity> getAllQuestion(){

        Result<List<QuestionSourceEntity>> result = new Result<>();
        result.setData(questionSourceService.getAllQuestion());
        return null;
    }

    /**
     * 根据问题类型获取问题
     */
    List<QuestionSourceEntity> getQuestionByType(String type);

    /**
     * 添加一个问题信息
     */
    Integer addQuestion(QuestionSourceEntity questionSourceEntity);

    /**
     * 更新一个问题信息
     */
    Integer updateQuestion(QuestionSourceEntity questionSourceEntity);

    /**
     * 删除一个问题信息通过编号
     */
    Integer deleteQuestionById(int id);
}
