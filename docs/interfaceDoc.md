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
Get/administrator-entity/getAdministratorById/{{id}}

#### 通过管理员id获取管理员信息

>参数说明  

| 名称  | 类型      | 必选    | 说明    |
|-----|---------|-------|-------|
| id  | String  | true  | 管理员ID |  
  

> 返回数据结构

|名称|类型|必选| 说明    |
|---|---|---|-------|
|message|String|---| ---   |
|status|String|---| 请求状态  |
|code|int|---| 状态码   |
|data|AdministratorEntity|---| 管理员信息 |  

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

  
***  
Post/administrator-entity/login  
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

```
{"message":"OK",
"status":true,
"code":200,
"data":
       "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
       eyJleHAiOjE2Nzc2Nzg2NDQsImlhdCI6MTY3NzY0MjY0
       NCwiYWNjb3VudCI6IjE0YTEzY2FlLTlkMzctNDFiMS1iNzVmLWM2ZTY2YjI3Nzg3ZiJ9.
       J2M7_lr8NVGUCO-pXJVp37Wa4pf8wXCKrk9ggZOlNAY"
}  
```    
```
{
	"message": "用户名或密码不正确",
	"status": false,
	"code": 404,
	"data": null
}
```    