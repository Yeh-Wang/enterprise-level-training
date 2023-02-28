package com.dev.enter.service.impl;

import com.dev.enter.entity.QuestionSourceEntity;
import com.dev.enter.mapper.QuestionSourceMapper;
import com.dev.enter.service.QuestionSourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Service
public class QuestionSourceServiceImpl extends ServiceImpl<QuestionSourceMapper, QuestionSourceEntity> implements QuestionSourceService {

    private QuestionSourceMapper questionSourceMapper;

    @Autowired
    public void setQuestionSourceMapper(QuestionSourceMapper questionSourceMapper){
        this.questionSourceMapper=questionSourceMapper;
    }

    @Override
    public List<QuestionSourceEntity> getAllQuestion() {
        return questionSourceMapper.selectList(null);
    }

    @Override
    public List<QuestionSourceEntity> getQuestionByType(String type) {
        return questionSourceMapper.getQuestionByType(type);
    }

    @Override
    public Integer addQuestion(QuestionSourceEntity questionSourceEntity) {
        return questionSourceMapper.insert(questionSourceEntity);
    }

    @Override
    public Integer updateQuestion(QuestionSourceEntity questionSourceEntity) {
        return questionSourceMapper.updateById(questionSourceEntity);
    }

    @Override
    public Integer deleteQuestionById(int id) {
        return questionSourceMapper.deleteById(id);
    }
}
