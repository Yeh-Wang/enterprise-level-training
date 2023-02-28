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
@TableName("student_info")
public class StudentInfoEntity {

    @TableId(value = "stu_id", type = IdType.AUTO)
    private String stuId;

    @TableField("stu_number")
    private String stuNumber;

    @TableField("stu_name")
    private String stuName;

    @TableField("age")
    private Integer age;

    @TableField("sex")
    private String sex;

    @TableField("telephone")
    private String telephone;

    @TableField("address")
    private String address;

    @TableField("qq")
    private String qq;

    @TableField("permissions")
    private Integer permissions;

    @TableField("learning_ability")
    private String learningAbility;

    @TableField("express_ability")
    private String expressAbility;

    @TableField("thinking_ability")
    private String thinkingAbility;

    @TableField("execute_ability")
    private String executeAbility;


}
