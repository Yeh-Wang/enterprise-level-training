package com.dev.enter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @since 2023-02-28 10:59:36
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("question_source")
public class QuestionSourceEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("content")
    private String content;

    @TableField("option_a")
    private String optionA;

    @TableField("option_b")
    private String optionB;

    @TableField("option_c")
    private String optionC;

    @TableField("option_d")
    private String optionD;

    @TableField("question_type")
    private String questionType;

    @TableField("score_a")
    private Integer scoreA;

    @TableField("score_b")
    private Integer scoreB;

    @TableField("score_c")
    private Integer scoreC;

    @TableField("score_d")
    private Integer scoreD;


}
