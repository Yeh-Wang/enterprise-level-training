# 后端接口文档

## 问题信息

### Get

Get /question-source-entity/getAllQuestion

#### 返回数据结构
| 名称      | 类型                         | 必选  | 说明      |
|---------|----------------------------|-----|---------|
| message | String                     | --- | ------- |
| status  | String                     | --- | 成功      |
| code    | int                        | --- | 状态码     |
| data    | List(QuestionSourceEntity) | --- | 所有问题信息  |

## 管理员信息
***
### Get
***
Get/administrator-entity/getAllAdministrator/{{id}}

#### 通过管理员id获取管理员信息

>参数说明
| 名称  | 类型      | 必选    | 说明    |
|-----|---------|-------|-------|
| id  | String  | true  | 管理员ID |  
  
> 返回示例  
  
```
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