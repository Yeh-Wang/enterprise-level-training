# Get

***
Get/administrator-entity/getAllAdministrator

|名称|类型|必选| 说明                      |
|---|---|---|-------------------------|
|id|string|---| 管路员id                   |
|user_name|string|---| 管理员用户名                  |
|real_name|string|---| 管理用姓名                   |
|age|int|---| 年龄                      |
|telephone|string|---| 电话                      |
|user_pwd|string|---| 密码                      |
|sexy|string|---| 性别                      |
|user_type|int|---| 用户类型（1表示超级管理员，0表示普通管理员） |  
  
>> 返回示例  
  
```
{"message":"成功",
"status":null,
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