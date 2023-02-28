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
@TableName("administrator")
public class AdministratorEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("user_name")
    private String userName;

    @TableField("real_name")
    private String realName;

    @TableField("age")
    private Integer age;

    @TableField("telephone")
    private String telephone;

    @TableField("user_pwd")
    private String userPwd;

    @TableField("sexy")
    private String sexy;

    @TableField("user_type")
    private Integer userType;


}
