# dicom-web-pacs

#### 介绍
web 影像归档阅片系统

#### 软件架构
SpringBoot 作为基础架构

MySql作为数据库

存储使用MINIO/OSS

Dicom协议相关使用DCM4CHEE实现

目前实现了Dicom的接收和存储，接下来将实现DICOM的解析和归档，这部分可能会遇到一些问题，最后在会新建项目来实现Dicom的Web阅片功能


#### 安装教程
各个模块都可以使用java -jar 直接启动

#### 使用说明

1. web-pacs-scp 用来接收CT设备传输过来的Dicom影像

2. web-pacs-view 用来实现web展示DICOM影像


#### 联系我
如果你有什么问题都可以随时给我邮件
lainiao@live.cn