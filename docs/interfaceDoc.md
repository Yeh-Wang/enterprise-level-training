# 后端接口文档

## 学员

### Post 查找所有的学员信息

post /student-info-entity/getAllStudentInfo

#### 请求头

| 请求头（Hear） | 必选   |
|-----------|------|
| token     | true |

#### 返回类型

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

Get /student-info-entity/findStudentByStuNumber

#### 参数表格如下

| 名称        | 类型     | 必选    | 说明    |
|-----------|--------|-------|-------|
| stuNumber | string | true	 | 学生的学号 |

#### 返回数据类型

| 名称      | 类型          | 必选   | 说明     |
|---------|-------------|------|--------|
| code    | int         | true | 状态码    |
| message | string      | true | 提示信息   |
| Data    | studentInfo | true | 返回的数据  |
| states  | boolean     | true | 正确还是错误 |

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

| 名称              | 类型     | 必选    | 说明    |
|:----------------|:-------|:------|:------|
| stuId           | string | true  | 学生id  |
| stuNumber       | string | true  | 学生学号  |
| stuName         | string | true  | 学生姓名  |
| age             | number | false | 年龄    |
| sex             | string | false | 性别    |
| telephone       | string | true  | 电话    |
| address         | string | true  | 家庭地址  |
| qq              | string | false | QQ    |
| permissions     | number | false | 权限    |
| learningAbility | string | false | 学习能力  |
| expressAbility  | string | false | 表达能力  |
| thinkingAbility | string | false | 逻辑思维  |
| executeAbility  | string | false | 执行能力	 |

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
| stuId            | string | true  | 学生id |
| stuNumber        | string | true  | 学生学号 |
| stuName          | string | true  | 学生姓名 |
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

| 名称    | 类型     | 必填   | 说明    |
|-------|--------|------|-------|
| stuId | string | true | 学生的id |

#### 返回信息
````
{
"message": "删除成功",
"status": true,
"code": 200,
"data": 0
}
````
## Get 获取女生性别比例

### Get /student-info-entity/getFemaleProp

参数信息
````
null
````
返回数据类型

| 名称    | 类型     | 必选   | 说明    |
|-------|--------|------|-------|
| name  | string | true | 名称    |
| value | number | true | 性别百分比 |

返回信息
````
[
  {
    "name":"女",
    "value":36.36363636363637
  }
]
````
## Get 获得男生性别比例

### Get  /student-info-entity/getMaleProp

参数信息
````
null
````
返回数据类型

<br/>

| 名称    | 类型     | 必选   | 说明    |
|-------|--------|------|-------|
| name  | string | true | 名称    |
| value | number | true | 性别百分比 |

<br/>

返回数据示例
````
[
   {
      "name":"男",
      "value":63.63636363636363
   }
]
````
## Get 同时获得男女比例

### Get /student-info-entity/getSexNumber

参数信息
````
    null
````
返回数据类型

<br/>

| 名称    | 类型     | 必选   | 说明    |
|-------|--------|------|-------|
| name  | string | true | 名称    |
| value | number | true | 性别百分比 |

返回数据示例
````
[

    {"name":"女","value":36.36363636363637},

    {"name":"男","value":63.63636363636363}

]
````
## Get 	得到学习能力的各种评分的各自的人数

###  Get /student-info-entity/getStudentLearningAbility

参数信息
````
null
````
返回的数据类型

<br/>

| 名称    | 类型     | 必选   | 说明     |
|-------|--------|------|--------|
| name  | string | true | 学习能力评分 |
| value | number | true | 对应的人数  |

返回数据示例
````
[

{"name":"学习能力优秀","value":16},

{"name":"学习能力良好","value":20},

{"name":"学习能力及格","value":8}

]
````
## Get     得到表达能力的各种评分的各自的人数

### Get /student-info-entity/getStudentExpressAbility

参数信息
````
    null
````
返回数据类型

<br/>

| 名称    | 类型     | 必选   | 说明     |
|-------|--------|------|--------|
| name  | string | true | 表达能力评分 |
| value | number | true | 对应的人数  |

<br/>

返回数据实例
````
[

{"name":"表达能力优秀","value":9},

{"name":"表达能力良好","value":18},

{"name":"表达能力及格","value":17}

]
````
## Get     得到思维能力的各种评分的各自的人数

### Get /student-info-entity/getStudentThinkingAbility

参数信息
````
null
````
返回数据类型

<br/>

| 名称    | 类型     | 必选   | 说明     |
|-------|--------|------|--------|
| name  | string | true | 思维能力评分 |
| value | number | true | 对应的人数  |

返回数据实例
````
    [

      {"name":"思维能力优秀","value":12},

      {"name":"思维能力良好","value":21},

      {"name":"思维能力及格","value":11}

    ]
````
## Get     得到执行能力的各种评分的各自的人数

### Get /student-info-entity/getStudentExecuteAbilityNumber

参数信息
````
null
````
返回数据类型

<br/>

| 名称    | 类型     | 必选   | 说明     |
|-------|--------|------|--------|
| name  | string | true | 执行能力评分 |
| value | number | true | 对应的人数  |

<br/>

返回数据实例
````
[

     {"name":"执行能力优秀","value":16},

     {"name":"执行能力良好","value":15},

     {"name":"执行能力及格","value":13}

]
````
## Get 可视化地图用的数据返回地点名和人数。

### Get /student-info-entity/getAddressNumber

参数数据
````
    null
````
返回数据类型

<br/>

| 名称    | 类型     | 必选   | 说明    |
|-------|--------|------|-------|
| name  | string | true | 地名    |
| value | number | true | 对应的人数 |

返回数据实例
````
[
{
"地址": "北京市",
"人数": 6
},
{
"地址": "重庆市",
"人数": 6
},
{
"地址": "河南省",
"人数": 4
},
{
"地址": "山西省",
"人数": 2
},
{
"地址": "湖北省",
"人数": 3
},
{
"地址": "吉林省",
"人数": 2
},
{
"地址": "上海市",
"人数": 3
},
{
"地址": "江苏省",
"人数": 5
},
{
"地址": "广东省",
"人数": 3
},
{
"地址": "黑龙江省",
"人数": 1
},
{
"地址": "福建省",
"人数": 2
},
{
"地址": "西藏省",
"人数": 1
},
{
"地址": "河北省",
"人数": 2
},
{
"地址": "海南省",
"人数": 2
},
{
"地址": "陕西省",
"人数": 1
},
{
"地址": "新疆省",
"人数": 1
}
]
````
## Get 可视化地图用的数据返回地点名，经纬度和人数。

### Get /student-info-entity/getPoint

参数信息
````
null
````
返回数据类型

<br/>

| 名称    | 类型           | 必选   | 说明    |
|-------|--------------|------|-------|
| name  | string       | true | 地名    |
| value | List<number> | true | 对应的人数 |

返回数据实例
````
[
{
"name": "北京市",
"value": [
116.4133836971231,
39.910924547299565,
6
]
},
{
"name": "重庆市",
"value": [
106.55843415537664,
29.568996245338923,
6
]
},
{
"name": "河南省",
"value": [
113.75938408486323,
34.771712921931496,
4
]
},
{
"name": "山西省",
"value": [
112.56937550968271,
37.87982942385603,
2
]
},
{
"name": "湖北省",
"value": [
114.34844073658718,
30.551600064658352,
3
]
},
{
"name": "吉林省",
"value": [
125.33257987514821,
43.90171443544392,
2
]
},
{
"name": "上海市",
"value": [
121.48053886017651,
31.235929042252014,
3
]
},
{
"name": "江苏省",
"value": [
118.76955164466914,
32.066776944293416,
5
]
},
{
"name": "广东省",
"value": [
113.27242891272826,
23.13794855653905,
3
]
},
{
"name": "黑龙江省",
"value": [
126.66965282041836,
45.74792983743469,
1
]
},
{
"name": "福建省",
"value": [
119.30244747703945,
26.106339415901047,
2
]
},
{
"name": "西藏省",
"value": [
91.12434212899261,
29.652893647472517,
1
]
},
{
"name": "河北省",
"value": [
114.53659630531568,
38.04320164520046,
2
]
},
{
"name": "海南省",
"value": [
110.35529396839667,
20.024489976328,
2
]
},
{
"name": "陕西省",
"value": [
108.96039314875111,
34.27580800602361,
1
]
},
{
"name": "新疆省",
"value": [
87.63347320573824,
43.79923810128996,
1
]
}
]

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

| 名称       | 类型     | 必选   | 说明     |
|----------|--------|------|--------|
| userName | String | true | 管理员用户名 |
| password | String | true | 密码     |
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

***  

Post/administrator-entity/register
#### 管理员注册账号,前端返回一个管理员类

> 请求参数

| 名称            | 类型                  | 必选   | 说明         |
|---------------|---------------------|------|------------|
| administrator | AdministratorEntity | true | 一个管理员信息实体类 |  

> 返回数据结构

| 名称      | 类型     | 必选  | 说明     |
|---------|--------|-----|--------|
| message | String | --- | 注册提示信息 |
| status  | Bool   | --- | 成功与否   |
| code    | int    | --- | 状态码    |
| data    | string | --- | ---    |  

> 返回示例

```json
{
	"message": "注册成功",
	"status": true,
	"code": 200,
	"data": "1"
}
```  
用户名被占用
```json
{
	"message": "用户名已被占用",
	"status": false,
	"code": 404,
	"data": "0"
}
```  
***  
Post/administrator-entity/modifyAdministratorInfo
#### 修改管理员信息  
> 请求参数

| 名称            | 类型                  | 必选   | 说明         |
|---------------|---------------------|------|------------|
| administrator | AdministratorEntity | true | 一个管理员信息实体类 |    
    
> 返回数据结构 

| 名称      | 类型     | 必选  | 说明     |
|---------|--------|-----|--------|
| message | String | --- | 注册提示信息 |
| status  | Bool   | --- | 成功与否   |
| code    | int    | --- | 状态码    |
| data    | string | --- | ---    |    

> 返回示例  

```json
{
  "message": "修改成功",
  "status": true,
  "code": 200,
  "data": "1"
}
```   
***  
Get /administrator-entity/modifyPassword/{id},{newPassword}  
### 管理员修改密码  
#### 前端传来管理员的id和新修改的密码，验证旧密码是否正确在前端处理
> 请求参数

| 名称          | 类型     | 必选   | 说明     |
|-------------|--------|------|--------|
| id          | string | true | 管理员id  | 
| newPassword | string | true | 修改的新密码 |   
  
> 返回数据结构

| 名称      | 类型     | 必选  | 说明       |
|---------|--------|-----|----------|
| message | string | --- | 修改密码提示信息 |
| status  | Bool   | --- | 成功与否     |
| code    | int    | --- | 状态码      |
| data    | int    | --- | ---      |    
  
> 返回示例  
```json
{
  "message": "修改成功",
  "status": true,
  "code": 200,
  "data": 1
}
```   

## 申请审核表

### Get  获取所有申请审核表信息

Get  /stu-to-auditor-entity/getAllAuditorInfo

返回数据结构

| 名称      | 类型                 | 必选   | 说明      |
|---------|--------------------|------|---------|
| message | string             | ---- | ------- |
| status  | boolean            | ---- | 成功      |
| code    | int                | ---- | 状态码     |
| data    | List(StuToAuditor) | ---- | 审核信息表信息 |

> 返回示例

```json
{"message":"OK",
"status":true,
"code":200,
"data":[{
  "id":4,
  "reasonContent":"dasdsa",
  "result":"das",
  "applicant":"张三",
  "auditor":"蓝天翔"
}]
}
```

###   增加审核表信息
Post /audit-table-entity/insertAuditTable

### 参数信息

| 名称            | 类型            | 必选    | 说明    |
|---------------|---------------|-------|-------|
| id            | int           | ---   | 审核表id |
| applicant     | string(学生ID)  | true  | 申请人   |
| audit         | string(管理员ID) | false | 审核人   |
| reasonContent | string        | ---   | 申请原因  |  
| result        | string        |       | 审核结果  |

### 返回数据类型

| 名称      | 类型      | 必选   | 说明      |
|---------|---------|------|---------|
| message | string  | ---- | ------- |
| status  | boolean | ---- | 成功      |
| code    | int     | ---- | 状态码     |
| data    | string  | ---- | 添加成功备注  |

### 删除审核表信息
Get /audit-table-entity/deleteAuditTable

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
### 更新审核表
Post /audit-table-entity/updateAuditTable

### 请求参数名称

| 名称            | 类型            | 必选    | 说明    |
|---------------|---------------|-------|-------|
| id            | int           | ---   | 审核表id |
| applicant     | string(学生ID)  | true  | 申请人   |
| audit         | string(管理员ID) | false | 审核人   |
| reasonContent | string        | ---   | 申请原因  |  
| result        | string        |       | 审核结果  |
### 返回数据结构

| 名称      | 类型      | 必选   | 说明      |
|---------|---------|------|---------|
| message | string  | ---- | ------- |
| status  | boolean | ---- | 成功      |
| code    | int     | ---- | 状态码     |
| data    | string  | ---- | 删除成功备注  |
```json
{"message":"OK",
"status":true,
"code":200,
"data":"更新成功"
}
```
### 通过id查找审核表
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
| data    | string  | ---- | 查找成功备注  |
> 返回示例

```json
{"message":"查找成功！",
  "status":true,
  "code":200,"data":
{"id":5,
  "applicant":"bb11",
  "auditor":"973309d4-3b23-4bed-a436-f4ceffdf1573",
  "reasonContent":"fgsdg",
  "result":"dgs"}}
```  
  
***  
### 点击通过按钮通过申请    
Get/audit-table-entity/changePermissionById/{{id}},{{administratorId}}  

#### 通过申请，将result修改为“已通过”，以及将stuInfo的permission改为1  
> 请求参数  

| 名称              | 类型     | 必选   | 说明     |
|-----------------|--------|------|--------|
| id              | int    | true | 审核表的id |
| administratorId | String | true | 管理员的ID |  
  
> 返回数据结构  

| 名称      | 类型      | 必选   | 说明         |
|---------|---------|------|------------|
| message | string  | ---- | -------    |
| status  | boolean | ---- | 成功         |
| code    | int     | ---- | 状态码        |
| data    | int     | ---- | 1为成功,0为不成功 |  
  
> 返回示例  

```json
{
  "message": "已批准",
  "status": true,
  "code": 200,
  "data": 1
}
```  
***    
### 发送邮件
Get/audit-table-entity/sendEmailToUser/{{id}}  
> 请求参数

| 名称              | 类型     | 必选   | 说明     |
|-----------------|--------|------|--------|
| id              | int    | true | 审核表的id |   

> 返回数据结构

| 名称      | 类型      | 必选   | 说明      |
|---------|---------|------|---------|
| message | string  | ---- | ------- |
| status  | boolean | ---- | 成功      |
| code    | int     | ---- | 状态码     |
| data    | string  | ---- | ---     |  

> 返回示例

```json
{
  "message": "successful",
  "status": true,
  "code": 200,
  "data": "successful"
}
```