# 后端接口文档

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
