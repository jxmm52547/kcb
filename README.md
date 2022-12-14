# 适用于Mirai的班群课程表插件

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

[MiraiForum](https://mirai.mamoe.net/)  
官方社区的插件开源代码

## 二.使用方法

### 1.简介


采用`.json`文件格式存储课表,文件位于`./kcb_data/Class Schedule Card.json`

从[Releases](https://github.com/jxmm52547/kcb/releases)下载插件放置于`./plugins`  
首次启动会自动创建，如果损坏可删除文件后重新启动

### 2.指令

**无需下载[chat-command](https://github.com/project-mirai/chat-command)皆可在聊天内使用指令**
**仅群内可用**

#### a.修改课表

* `修改周[一;二;三;四;五;六;日]课表为:` **注意是中文冒号**  后接要修改为的内容——例如`修改周一课表为：203  java  理论  张三`修改成功将会提示
* `修改今日课表为：`(获取今日周几并修改当日课表)**注意是中文冒号**    后接要修改为的内容——例如`修改今日课表为：203  java  理论  张三`修改成功将会提示
* `修改明日课表为：`**注意是中文冒号**  后街要修改为的内容——例如 `修改明日课表为：203  java  理论  张三`修改成功将会提示

#### b.查看课表

* `今日课表`  获取今日星期几然后从文件中读取课表发送至群聊  
* `明日课表`  获取到明日周几并读取数据文件
* `周[一;二;三;四;五;六;日]课表`  获取指定周几课表发送至班群

#### c.开关课表

**如果启用，获取课表时将会发送内容；如果关闭，则会提示** `课表关闭`
* `启用周[一;二;三;四;五;六;日]`启用指定周几课表
* `关闭周[一;二;三;四;五;六;日]`关闭指定周几课表
* `启用今日课表`
* `关闭今日课表`
* `启用明日课表`
* `关闭明日课表`

#### d.时间   

（多多少少没什么用）
* `now`获取现在时间及星期发送至群内
* `开机时间`获取bot启动的时间发送至群内

## 三.更新日志

###  V0.1.1
修复 `V0.01`; `V0.0.2`; `V0.03`版本(未发布)重大BUG,更换写法,更换数据储存方式


###  V0.1.2
增加新内容  
> 
> `修改明日课表为：`  
> `明日课表`  
> `启用明日课表`  
> ``关闭明日课表``  
> 
> *增加周六周日课表*
>
***此次更新需要删除旧版本课表文件***

## 四.特别鸣谢

本插件由[Cjsah](https://github.com/Cjsah)提供技术支持
