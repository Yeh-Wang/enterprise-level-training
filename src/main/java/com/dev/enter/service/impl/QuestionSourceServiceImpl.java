package com.dev.enter.service.impl;

import com.dev.enter.entity.QuestionSourceEntity;
import com.dev.enter.mapper.QuestionSourceMapper;
import com.dev.enter.service.QuestionSourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public List<QuestionSourceEntity> getAllQuestion() {
        return null;
    }
}
