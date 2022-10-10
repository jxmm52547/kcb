# xyz.jxmm.kcb

## 一.介绍

### 1.此项目为[靖暄](https://wpa.qq.com/msgrd?uin=1250838250)个人制作用于班群课表的 [Mirai Console](https://github.com/mamoe/mirai-console) 插件，同样兼容[Mirai core](https://github.com/sonder-joker/mirai-compose)

纯萌新制作，本人无任何java  kotlin基础，仅编写过  
html  
JavaScript  
css  
jQuery  
json

[//]: # (### 2.模板使用来自)

[//]: # ()
[//]: # ([Mirai Console]&#40;https://github.com/mamoe/mirai-console&#41; 插件模板, 使用 Kotlin + Gradle.)

[//]: # ()
[//]: # ([如何使用]&#40;https://github.com/project-mirai/how-to-use-plugin-template&#41;)
### 2.灵感来源与
[Kloping/Mirai_Plugins_Auto_Reply](https://github.com/Kloping/Mirai_Plugins_Auto_Reply)
的自定义回复

### 3.代码参考于
[kono-dada/doudizhu](https://github.com/kono-dada/doudizhu)  
这个插件的开源代码让我写出了此插件

## 二.使用方法

### 1.简介


采用`.json`文件格式存储课表,文件位于`./kcb_data/Class Schedule Card.json`

从[Releases](https://github.com/jxmm52547/kcb/releases)下载插件放置于`./plugins`  
首次启动会自动创建，如果损坏可删除文件后重新启动

### 2.指令
**无需下载[chat-command](https://github.com/project-mirai/chat-command)皆可在聊天内使用指令
仅群内可用**

#### 1.修改课表
* `修改周[一;二;三;四;五]课表为:` **注意是中文冒号**  后接要修改为的内容——例如`修改周一课表为：203  java  理论  张三`修改成功将会提示
* `修改今日课表为：`(获取今日周几并修改当日课表)**注意是中文冒号**    后接要修改为的内容——例如`修改今日课表为：203  java  理论  张三`修改成功将会提示
#### 2.查看课表
* `今日课表`  获取今日星期几然后从文件中读取课表发送至群聊  
暂未添加获取明日课表功能，有望在后续版本添加
#### 3.开关课表
**如果启用，获取课表时将会发送内容；如果关闭，则会提示** `课表关闭`
* `启用周[一;二;三;四;五]`启用指定周几课表
* `关闭周[一;二;三;四;五]`关闭指定周几课表
* `启用今日课表`启用当日课表
* `关闭今日课表`关闭当日课表
#### 4.时间   
（多多少少没什么用）
* `now`获取现在时间及星期发送至群内
* `开机时间`获取bot启动的时间发送至群内

## 三.特别鸣谢
本插件由[Cjsah](https://github.com/Cjsah)提供技术支持