# 后端接口文档

## 问题信息

### Get

Get /question-source-entity/getAllQuestion

#### 返回数据结构

| 名称      | 类型           | 必选  | 说明      |
|---------|--------------|-----|---------|
| message | String       | --- | ------- |
| status  | String       | --- | 成功      |
| code    | int          | --- | 状态码     |
| data    | List<object> | --- | 所有问题信息  |
