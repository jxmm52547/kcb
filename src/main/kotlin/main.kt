package org.jxmm.kcb

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.utils.info
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.concurrent.thread
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.Local


/**
 * 使用 kotlin 版请把
 * `src/main/resources/META-INF.services/net.mamoe.mirai.console.plugin.jvm.JvmPlugin`
 * 文件内容改成 `org.example.mirai.plugin.PluginMain` 也就是当前主类全类名
 *
 * 使用 kotlin 可以把 java 源集删除不会对项目有影响
 *
 * 在 `settings.gradle.kts` 里改构建的插件名称、依赖库和插件版本
 *
 * 在该示例下的 [JvmPluginDescription] 修改插件名称，id和版本，etc
 *
 * 可以使用 `src/test/kotlin/RunMirai.kt` 在 ide 里直接调试，
 * 不用复制到 mirai-console-loader 或其他启动器中调试
 */

object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "org.jxmm.kcb",
        name = "课程表",
        version = "0.0.2"
    ) {
        author("作者:靖暄;QQ:1250838250")
        info(
            """
            这是靖暄的自动获取课程表插件, 
        """.trimIndent()
        )
        // author 和 info 可以删除.
    }
) {
    override fun onEnable() {
        logger.info { "课程表已加载" }
        weekStudy.reload()
        Config.reload()
        //配置文件目录 "${dataFolder.absolutePath}/"
        val eventChannel = GlobalEventChannel.parentScope(this)
        eventChannel.subscribeAlways<GroupMessageEvent>{
            //群消息

            //复读示例 弃用!!
            if (message.contentToString().startsWith("复读")) {
                group.sendMessage(message.contentToString().replace("复读", ""))
            }

            //周1
            if (message.contentToString().startsWith("修改周一课表为:")) {
                weekStudy.wd1 = (message.contentToString().replace("修改周一课表为:", "").toString())
                group.sendMessage("请等待5秒")
                weekStudy.reload()
                Thread.sleep(5_000)
                group.sendMessage("ok")
            }
            //周2
            if (message.contentToString().startsWith("修改周二课表为:")) {
                weekStudy.wd2 = (message.contentToString().replace("修改周二课表为:", "").toString())
                group.sendMessage("请等待5秒")
                weekStudy.reload()
                Thread.sleep(5_000)
                group.sendMessage("ok")
            }
            //周3
            if (message.contentToString().startsWith("修改周三课表为:")) {
                weekStudy.wd3 = (message.contentToString().replace("修改周三课表为:", "").toString())
                group.sendMessage("请等待5秒")
                weekStudy.reload()
                Thread.sleep(5_000)
                group.sendMessage("ok")
            }
            //周4
            if (message.contentToString().startsWith("修改周四课表为:")) {
                weekStudy.wd4 = (message.contentToString().replace("修改周四课表为:", "").toString())
                group.sendMessage("请等待5秒")
                weekStudy.reload()
                Thread.sleep(5_000)
                group.sendMessage("ok")
            }
            //周5
            if (message.contentToString().startsWith("修改周五课表为:")) {
                weekStudy.wd5 = (message.contentToString().replace("修改周五课表为:", "").toString())
                group.sendMessage("请等待5秒")
                weekStudy.reload()
                Thread.sleep(5_000)
                group.sendMessage("ok")
            }
//            if (message.contentToString() == "hi") {
//                //群内发送
//                group.sendMessage("hi")
//                //向发送者私聊发送消息
//                sender.sendMessage("hi")
//                //不继续处理
//                return@subscribeAlways
//            }
            //分类示例
//            message.forEach {
//                //循环每个元素在消息里
//                if (it is Image) {
//                    //如果消息这一部分是图片
//                    val url = it.queryUrl()
//                    group.sendMessage("图片，下载地址$url")
//                }
//                if (it is PlainText) {
//                    //如果消息这一部分是纯文本
//                    group.sendMessage("纯文本，内容:${it.content}")
//                }
//            }
            //获取当前时间

            if (message.contentToString() == "now"){
                val time = LocalDateTime.now()
                val week = (time.dayOfWeek).toString()
                group.sendMessage("现在时间: $time")
                group.sendMessage("现在时间: $week")
                return@subscribeAlways
            }

            if (message.contentToString() == "开机时间"){
                val sdf = SimpleDateFormat("YYYY-MM-dd hh:mm:ss EEEE  z")
                val time = sdf.format(date)
                group.sendMessage("开机时间为: $time")
            }
            if (message.contentToString() == "今日课表"){
                val time = LocalDateTime.now().dayOfWeek
                val week = time.toString()
                if (week == "MONDAY"){
                    group.sendMessage("周一课表为: $kb1")
                } else if (week == "TUESDAY"){
                    group.sendMessage("周二课表为: $kb2")
                } else if (week == "WEDNESDAY"){
                    group.sendMessage("周三课表为: $kb3")
                } else if (week == "THURSDAY"){
                    group.sendMessage("周四课表为: $kb4")
                } else{
                    group.sendMessage("周五课表为: $kb5")
                }
            }
            if (message.contentToString() == "/kcb_reload"){
                weekStudy.reload()
                group.sendMessage("请等待5秒")
                Thread.sleep(5_000)
                group.sendMessage("重载数据完毕")
            }
        }
//        eventChannel.subscribeAlways<FriendMessageEvent>{
//            //好友信息
//            sender.sendMessage("hi")
//        }
//        eventChannel.subscribeAlways<NewFriendRequestEvent>{
//            //自动同意好友申请
//            accept()
//        }
//        eventChannel.subscribeAlways<BotInvitedJoinGroupRequestEvent>{
//            //自动同意加群申请
//            accept()
//        }
    }
}

object date : Date() {

}



