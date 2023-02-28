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
@TableName("audit_table")
public class AuditTableEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("applicant")
    private String applicant;

    @TableField("auditor")
    private String auditor;

    @TableField("reason_content")
    private String reasonContent;

    @TableField("result")
    private String result;


}
