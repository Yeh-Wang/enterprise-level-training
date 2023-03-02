package com.dev.enter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : Yaxin-Wang
 * @date : 2023/3/2
 */
@Data
@Accessors(chain = true)
@TableName("stu_to_auditor")
public class StuToAuditorEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("reason_content")
    private String reasonContent;

    @TableField("result")
    private String result;

    @TableField("applicant")
    private String applicant;

    @TableField("auditor")
    private String auditor;
}
