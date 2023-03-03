package com.dev.enter.mapper;

import com.dev.enter.entity.QuestionSourceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Mapper
public interface QuestionSourceMapper extends BaseMapper<QuestionSourceEntity> {

    @Select("select * from question_source where question_type = #{type}")
    List<QuestionSourceEntity> getQuestionByType(@Param("type") String type);

}
