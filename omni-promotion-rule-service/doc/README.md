##omni-promotion-rule-interface
负责接口service的定义、Bean的定义、rule中事实的存放

##omni-promotion-rule-admin
PC端规则管理后台的接口统一入口路径

##omni-promotion-rule-server
PC端规则后台管理和其他消费方服务提供的service具体实现

##rule-engine-admin-third
提供给第三方的controller接口实现，第三方系统要进行规则引擎接口统一写在这里

##rule-engine-mq 异步消息服务
该模块负责消息的生产和消费,主要有以下几部分的业务
1.记录PC后台的规则的操作日志
2.规则的匹配的日志详情信息
3.规则引擎的调用日志(输入和输出)
