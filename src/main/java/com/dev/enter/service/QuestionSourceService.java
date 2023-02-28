package com.dev.enter.service;

import com.dev.enter.entity.QuestionSourceEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
public interface QuestionSourceService extends IService<QuestionSourceEntity> {

    /**
     * 获取所有问题信息
     */
    List<QuestionSourceEntity> getAllQuestion();

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
