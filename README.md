# code-generator
代码生成器
#特性
模型转换
独立模型
数据库模型
语言相关的模型
提供可视化的yaml配置
可修改调整
支持生成dbscript，支持生成ui（ webform，支持其他的view框架，swing)


# 生成步骤
1. 选择模型来源：
a. 从db中构建模型
b. 从独立模型中构建

2. 扩展模型
生成db
生成lang信息
生成ui信息
3. 修改模型信息
4. 保存模型信息
5. 模型处理成key形式
6. 通过模版引擎生成信息


#注意
不同模型转换会出现信息不足，需要补充具体的模型。

推荐模板书写方式，先写一个demo，然后在这个框架下编写模版。


参考
mybatis-generator
单个model, source  target   ftl



代码结构
generator
tpl
config
domain模型
  db模型转换
  模型扩展extend
  project  module  每个module支持分层





