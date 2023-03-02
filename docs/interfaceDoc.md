# 学员

## Get 查找所有的学员信息

### Get /student-info-entity/getAllStudentInfo

请求头

| 请求头（Hear） | 必选   |
|-----------|------|
| token     | true |

返回数据类型

| 名称      | 类型                 | 必选   | 说明     |
|---------|--------------------|------|--------|
| code    | int                | true | 状态码    |
| message | string             | true | 提示信息   |
| Data    | List<student_info> | true | 返回的数据  |
| states  | boolean            | true | 正确还是错误 |

返回示例

成功示例
````
{
"message": "查找成功！",
"status": true,
"code": 200,
"data": [
{
"stuId": "bb11",
"stuNumber": "632001231",
"stuName": "闵乙洪",
"age": 21,
"sex": "女",
"telephone": "1231431",
"address": "重庆",
"qq": "13659883",
"permissions": 0,
"learningAbility": "优",
"expressAbility": "中",
"thinkingAbility": "优",
"executeAbility": "优"
},
{
"stuId": "cc11",
"stuNumber": "64213121",
"stuName": "王经理",
"age": 21,
"sex": "女",
"telephone": "1243412",
"address": "河南周口",
"qq": "12312123",
"permissions": 0,
"learningAbility": "优",
"expressAbility": "优",
"thinkingAbility": "优",
"executeAbility": "优"
},
{
"stuId": "dd11",
"stuNumber": "6320070604",
"stuName": "倪泽宇",
"age": 21,
"sex": "男",
"telephone": "1234632",
"address": "江苏",
"qq": "12324456",
"permissions": 0,
"learningAbility": "优",
"expressAbility": "优",
"thinkingAbility": "优",
"executeAbility": "优"
}
]
}
````
<br/>

## Get 用学号查找学员

### Get /findStudentByStuNumber

参数表格如下

| 名称        | 类型     | 必选    | 说明    |
|-----------|--------|-------|-------|
| stuNumber | string | true	 | 学生的学号 |

返回数据类型

| 名称      | 类型           | 必选   | 说明     |
|---------|--------------|------|--------|
| code    | int          | true | 状态码    |
| message | string       | true | 提示信息   |
| Data    | student_info | true | 返回的数据  |
| states  | boolean      | true | 正确还是错误 |

<br/>

返回示例

成功示例
````
{"message":"查找成功！",

"status":true,

"code":200,"

data":

      {

       "stuId":"dd11",

       "stuNumber":"6320070604",

       "stuName":"倪泽宇",

       "age":21,

       "sex":"男",

       "telephone":"1234632",

       "address":"江苏",

       "qq":"12324456",

       "permissions":0,

       "learningAbility":"优",

       "expressAbility":"优",

       "thinkingAbility":"优",

       "executeAbility":"优"

     }

}
````
## Get 用名字模糊查询学生信息

### Get /student-info-entity/findStudentByStuName

参数如下

<br/>

| 名称      | 类型     | 必选   | 说明   |
|---------|--------|------|------|
| stuName | string | true | 学生姓名 |

返回数据类型

| 名称      | 类型                 | 必选   | 说明     |
|---------|--------------------|------|--------|
| code    | int                | true | 状态码    |
| message | string             | true | 提示信息   |
| Data    | List<student_info> | true | 返回的数据  |
| states  | boolean            | true | 正确还是错误 |

返回示例
````
{
"message": "查找成功！",
"status": true,
"code": 200,
"data": [
{
"stuId": "cc11",
"stuNumber": "64213121",
"stuName": "王经理",
"age": 21,
"sex": "女",
"telephone": "1243412",
"address": "河南周口",
"qq": "12312123",
"permissions": 0,
"learningAbility": "优",
"expressAbility": "优",
"thinkingAbility": "优",
"executeAbility": "优"
}
]
}
````
## Post 更新学生信息

### Post /student-info-entity/updateStudent

参数信息

| 名称               | 类型     | 必选    | 说明    |
|:-----------------|:-------|:------|:------|
| stu_id           | string | true  | 学生id  |
| stu_number       | string | true  | 学生学号  |
| stu_name         | string | true  | 学生姓名  |
| age              | number | false | 年龄    |
| sex              | string | false | 性别    |
| telephone        | string | true  | 电话    |
| address          | string | true  | 家庭地址  |
| qq               | string | false | QQ    |
| permissions      | number | false | 权限    |
| learning_ability | string | false | 学习能力  |
| express_ability  | string | false | 表达能力  |
| thinking_ability | string | false | 逻辑思维  |
| execute-ability  | string | false | 执行能力	 |

返回数据类型

| 名称      | 类型      | 必选   | 说明     |
|---------|---------|------|--------|
| code    | int     | true | 状态码    |
| message | string  | true | 提示信息   |
| Data    | int     | true | 返回的数据  |
| states  | boolean | true | 正确还是错误 |

返回信息
````
{
"message": "更新成功",
"status": true,
"code": 200,
"data": 1
}
````
## Post 增加学生信息

### post /student-info-entity/insertStudentInfo

参数信息

| 名称               | 类型     | 必选    | 说明   |
|:-----------------|:-------|:------|:-----|
| stu_id           | string | true  | 学生id |
| stu_number       | string | true  | 学生学号 |
| stu_name         | string | true  | 学生姓名 |
| age              | number | false | 年龄   |
| sex              | string | false | 性别   |
| telephone        | string | true  | 电话   |
| address          | string | true  | 家庭地址 |
| qq               | string | false | QQ   |
| permissions      | number | false | 权限   |
| learning_ability | string | false | 学习能力 |
| express_ability  | string | false | 表达能力 |
| thinking_ability | string | false | 逻辑思维 |
| execute-ability  | string | false | 执行能力 |

返回数据类型

| 名称      | 类型      | 必选   | 说明     |
|---------|---------|------|--------|
| code    | int     | true | 状态码    |
| message | string  | true | 提示信息   |
| Data    | int     | true | 返回的数据  |
| states  | boolean | true | 正确还是错误 |

返回信息

成功返回
````
{
"message": "增加成功",
"status": true,
"code": 200,
"data": 1
}
````
## Get 删除学生信息

### Get /student-info-entity/deleteStudentById

参数信息

<br/>

| 名称     | 类型     | 必填   | 说明    |
|--------|--------|------|-------|
| stu_id | string | true | 学生的id |

返回信息
````
{
"message": "删除成功",
"status": true,
"code": 200,
"data": 0
}
````