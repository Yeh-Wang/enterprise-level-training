# 后端接口文档

## 学员

### Post 查找所有的学员信息

post /student-info-entity/getAllStudentInfo

#### 请求头

| 请求头（Hear） | 必选   |
|-----------|------|
| token     | true |

#### 返回数据类型

| 名称      | 类型                 | 必选  | 说明     |
|---------|--------------------|-----|--------|
| code    | int                | --- | 状态码    |
| message | string             | --- | 提示信息   |
| Data    | List<student_info> | --- | 返回的数据  |
| states  | boolean            | --- | 正确还是错误 |

#### 返回示例
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

### Get 用学号查找学员

Get /findStudentByStuNumber

#### 参数表格如下

| 名称        | 类型     | 必选    | 说明    |
|-----------|--------|-------|-------|
| stuNumber | string | true	 | 学生的学号 |

#### 返回数据类型

| 名称      | 类型           | 必选   | 说明     |
|---------|--------------|------|--------|
| code    | int          | true | 状态码    |
| message | string       | true | 提示信息   |
| Data    | student_info | true | 返回的数据  |
| states  | boolean      | true | 正确还是错误 |

<br/>

#### 返回示例

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
### Get 用名字模糊查询学生信息

Get /student-info-entity/findStudentByStuName

#### 参数如下

<br/>

| 名称      | 类型     | 必选   | 说明   |
|---------|--------|------|------|
| stuName | string | true | 学生姓名 |

#### 返回数据类型

| 名称      | 类型                 | 必选   | 说明     |
|---------|--------------------|------|--------|
| code    | int                | true | 状态码    |
| message | string             | true | 提示信息   |
| Data    | List<student_info> | true | 返回的数据  |
| states  | boolean            | true | 正确还是错误 |

#### 返回示例
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
### Post 更新学生信息

Post /student-info-entity/updateStudent

#### 参数信息

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

#### 返回数据类型

| 名称      | 类型      | 必选   | 说明     |
|---------|---------|------|--------|
| code    | int     | true | 状态码    |
| message | string  | true | 提示信息   |
| Data    | int     | true | 返回的数据  |
| states  | boolean | true | 正确还是错误 |

#### 返回信息
````
{
"message": "更新成功",
"status": true,
"code": 200,
"data": 1
}
````
### Post 增加学生信息

post /student-info-entity/insertStudentInfo

#### 参数信息

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

#### 返回数据类型

| 名称      | 类型      | 必选   | 说明     |
|---------|---------|------|--------|
| code    | int     | true | 状态码    |
| message | string  | true | 提示信息   |
| Data    | int     | true | 返回的数据  |
| states  | boolean | true | 正确还是错误 |

#### 返回信息

成功返回
````
{
"message": "增加成功",
"status": true,
"code": 200,
"data": 1
}
````
### Get 删除学生信息

Get /student-info-entity/deleteStudentById

#### 参数信息

<br/>

| 名称     | 类型     | 必填   | 说明    |
|--------|--------|------|-------|
| stu_id | string | true | 学生的id |

#### 返回信息
````
{
"message": "删除成功",
"status": true,
"code": 200,
"data": 0
}
````


## 问题信息

### Get  获取所有问题信息

Get  /question-source-entity/getAllQuestion

#### 返回数据结构

| 名称      | 类型                         | 必选   | 说明      |
|---------|----------------------------|------|---------|
| message | string                     | ---- | ------- |
| status  | boolean                    | ---- | 成功      |
| code    | int                        | ---- | 状态码     |
| data    | List(QuestionSourceEntity) | ---- | 所有问题信息  |

> 返回示例

```json
{"message":"OK",
"status":true,
"code":200,
"data":[{
  "id":"2417deae-23d2-1ee4-d219-2d430424f9ab",
  "content":"是否会学习",
  "optionA":"会",
  "optionB":"经常会",
  "optionC":"偶尔会",
  "optionD":"不会",
  "questionType":"学习能力",
  "scoreA":20,
  "scoreB":40,
  "scoreC":30,
  "scoreD":10
}]
}
```

### Get  根据问题类型获取问题信息

Get  /question-source-entity/getQuestionByType

#### 请求参数

| 名称   | 类型     | 必选   | 说明      |
|:-----|--------|:-----|---------|
| type | string | true | 问题的类型信息 |

#### 返回数据结构

| 名称      | 类型                         | 必选   | 说明        |
|---------|----------------------------|------|-----------|
| message | string                     | ---- | -------   |
| status  | boolean                    | ---- | 成功        |
| code    | int                        | ---- | 状态码       |
| data    | List(QuestionSourceEntity) | ---- | 指定类型的问题信息 |

> 返回示例

```json
{"message":"OK",
"status":true,
"code":200,
"data":[{
  "id":"2417deae-23d2-1ee4-d219-2d430424f9ab",
  "content":"是否会学习",
  "optionA":"会",
  "optionB":"经常会",
  "optionC":"偶尔会",
  "optionD":"不会",
  "questionType":"学习能力",
  "scoreA":20,
  "scoreB":40,
  "scoreC":30,
  "scoreD":10
}]
}
```

### Post  增加一个问题信息

Post  /question-source-entity/addQuestion

#### 请求参数

| 名称           | 类型     | 必选    | 说明    |
|:-------------|--------|:------|-------|
| id           | string | false | 问题编号  |
| content      | string | true  | 问题内容  |
| optionA      | string | true  | 选项A   |
| optionB      | string | true  | 选项B   |
| optionC      | string | false | 选项C   |
| optionD      | string | false | 选项D   |
| questionType | string | true  | 问题类型  |
| scoreA       | int    | true  | 选项A分值 |
| scoreB       | int    | true  | 选项B分值 |
| scoreC       | int    | false | 选项C分值 |
| scoreD       | int    | false | 选项D分值 |

> 请求示例

```json
{
  "id":"2417deae-23d2-1ee4-d219-2d430424f9ab",
  "content":"是否会学习",
  "optionA":"会",
  "optionB":"经常会",
  "optionC":"偶尔会",
  "optionD":"不会",
  "questionType":"学习能力",
  "scoreA":20,
  "scoreB":40,
  "scoreC":30,
  "scoreD":10
}
```

#### 返回数据结构

| 名称      | 类型      | 必选   | 说明      |
|---------|---------|------|---------|
| message | string  | ---- | ------- |
| status  | boolean | ---- | 成功      |
| code    | int     | ---- | 状态码     |
| data    | string  | ---- | 添加成功备注  |

> 返回示例

```json
{"message":"OK",
"status":true,
"code":200,
"data":"添加成功"
}
```

### Post  更新问题信息

post  /question-source-entity/updateQuestion

请求参数

| 名称           | 类型     | 必选    | 说明    |
|:-------------|--------|:------|-------|
| id           | string | true  | 问题编号  |
| content      | string | true  | 问题内容  |
| optionA      | string | true  | 选项A   |
| optionB      | string | true  | 选项B   |
| optionC      | string | false | 选项C   |
| optionD      | string | false | 选项D   |
| questionType | string | true  | 问题类型  |
| scoreA       | int    | true  | 选项A分值 |
| scoreB       | int    | true  | 选项B分值 |
| scoreC       | int    | false | 选项C分值 |
| scoreD       | int    | false | 选项D分值 |

> 请求示例

```json
{
  "id":"2417deae-23d2-1ee4-d219-2d430424f9ab",
  "content":"是否会学习",
  "optionA":"会",
  "optionB":"经常会",
  "optionC":"偶尔会",
  "optionD":"不会",
  "questionType":"学习能力",
  "scoreA":30,
  "scoreB":30,
  "scoreC":30,
  "scoreD":10
}
```

#### 返回数据结构

| 名称      | 类型      | 必选   | 说明      |
|---------|---------|------|---------|
| message | string  | ---- | ------- |
| status  | boolean | ---- | 成功      |
| code    | int     | ---- | 状态码     |
| data    | string  | ---- | 更新成功备注  |

> 返回示例

```json
{"message":"OK",
"status":true,
"code":200,
"data":"更新成功"
}
```

### Post  删除一条问题信息

post   /question-source-entity/deleteQuestion/{id}

#### 请求参数名称

| 名称  | 类型  | 必选   | 说明   |
|-----|-----|------|------|
| id  | int | true | 问题编号 |

返回数据结构

| 名称      | 类型      | 必选   | 说明      |
|---------|---------|------|---------|
| message | string  | ---- | ------- |
| status  | boolean | ---- | 成功      |
| code    | int     | ---- | 状态码     |
| data    | string  | ---- | 删除成功备注  |

> 返回示例

```json
{"message":"OK",
"status":true,
"code":200,
"data":"删除成功"
}
```

## 管理员信息
***
### Get
***
Get/administrator-entity/getAdministratorById/{id}

#### 通过管理员id获取管理员信息

>参数说明

| 名称  | 类型      | 必选    | 说明    |
|-----|---------|-------|-------|
| id  | String  | true  | 管理员ID |  


> 返回数据结构

| 名称      | 类型                  | 必选  | 说明    |
|---------|---------------------|-----|-------|
| message | String              | --- | ---   |
| status  | String              | --- | 请求状态  |
| code    | int                 | --- | 状态码   |
| data    | AdministratorEntity | --- | 管理员信息 |  

> 返回示例

```json
{"message":"成功",
"status":true,
"code":200,
"data":
       {
       "id":"123",
       "userName":"123",
       "realName":"闵",
       "age":23,
       "telephone":"1342321",
       "userPwd":"123456",
       "sexy":"男",
       "userType":0
       }
}  
```  

***  
Get/administrator-entity/login/{user_name},{password}
#### 用户登录验证，用户名密码正确后返回token验证密钥
> 请求参数

| 名称        | 类型     | 必选   | 说明     |
|-----------|--------|------|--------|
| user_name | String | true | 管理员用户名 |
| password  | String | true | 密码     |
> 返回数据结构

| 名称      | 类型     | 必选  | 说明         |
|---------|--------|-----|------------|
| message | String | --- | 登录提示信息     |
| status  | String | --- | 成功         |
| code    | int    | --- | 状态码        |
| data    | String | --- | token/null |

> 返回示例

```json
{"message":"OK",
"status":true,
"code":200,
"data": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2Nzc2Nzg2NDQsImlhdCI6MTY3NzY0MjY0NCwiYWNjb3VudCI6IjE0YTEzY2FlLTlkMzctNDFiMS1iNzVmLWM2ZTY2YjI3Nzg3ZiJ9.J2M7_lr8NVGUCO-pXJVp37Wa4pf8wXCKrk9ggZOlNAY"
}
```    
```json
{
	"message": "用户名或密码不正确",
	"status": false,
	"code": 404,
	"data": null
}
```  

