# org.jxmm.kcb

## 一.模板使用来自

[Mirai Console](https://github.com/mamoe/mirai-console) 插件模板, 使用 Kotlin + Gradle.

[如何使用](https://github.com/project-mirai/how-to-use-plugin-template)

## 二.介绍

此项目为[靖暄](http://wpa.qq.com/msgrd?v=3&uin=&site=qq&menu=yes)个人制作用于班群课表的 [Mirai Console](https://github.com/mamoe/mirai-console) 插件

纯萌新制作，本人无任何java  kotlin基础，仅编写过  
html  
JavaScript  
css  
jQuery  
json

### 1.灵感来源与
[Kloping/Mirai_Plugins_Auto_Reply](https://github.com/Kloping/Mirai_Plugins_Auto_Reply)
的自定义回复

### 2.代码参考于
[kono-dada/doudizhu](https://github.com/kono-dada/doudizhu)  
这个插件的开源代码让我写出了此插件

## 三.使用方法

### 1.简介
`./data/org.jxmm.kcb`含有靖暄的课表示例

采用yml配置文件方式存储课表,文件位于`./data/org.jxmm.kcb/weekStudy.yml`

从[Releases](https://github.com/jxmm52547/kcb/releases)下载插件放置于`./plugins`
首次启动会自动生成配置文件

### 2.指令
**无需下载[chat-command](https://github.com/project-mirai/chat-command)皆可在聊天内使用指令
仅群内可用**

### 1.修改课表
* `修改周一[二、三、四、五]课表为:` **注意是英文冒号**  后接要修改为的内容（可查看示例）
### 2.查看课表
* `今日课表`  获取今日星期几然后从文件中读取课表发送至群聊  
暂未添加获取明日课表功能，有望在后续版本添加
### 3.时间   
（多多少少没什么用）
* `now`获取现在时间及星期发送至群内
* `开机时间`获取bot启动的时间发送至群内