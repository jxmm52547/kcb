package xyz.jxmm

import com.google.gson.JsonObject
import net.mamoe.mirai.event.GlobalEventChannel
import net.mamoe.mirai.event.events.GroupMessageEvent
import java.io.File
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.HashMap

val map = HashMap<String, String>().also {
    it["MONDAY"] = "周一"
    it["TUESDAY"] = "周二"
    it["WEDNESDAY"] = "周三"
    it["THURSDAY"] = "周四"
    it["FRIDAY"] = "周五"
    it["周一"] = "MONDAY"
    it["周二"] = "TUESDAY"
    it["周三"] = "WEDNESDAY"
    it["周四"] = "THURSDAY"
    it["周五"] = "FRIDAY"
}

val configFile = File("./kcb_data/Class Schedule Card.json")
val startTime: String = SimpleDateFormat("YYYY-MM-dd hh:mm:ss EEEE  z").format(Date())

//课表相关
fun getCSC(){
    val json = gson.fromJson(configFile.readText(),JsonObject::class.java)
    val eventChannel = GlobalEventChannel.parentScope(Kcb)
    eventChannel.subscribeAlways<GroupMessageEvent>{

        val msg = message.contentToString()

        //获取课表
        if (msg == "今日课表"){
            val week = LocalDateTime.now().dayOfWeek.toString()
            if (json.has(week)) {
                val today = json[week].asJsonObject
                if (today["Enable"].asBoolean){//获取当日课表是否启用   如果启用即发送，如果关闭即提示
                    group.sendMessage("${map[week]}课表为: ${today["value"].asString}")
                } else {
                    group.sendMessage("${map[week]}课表关闭")
                }
            }
        }

        //第一种方式修改课表  (指定修改周几课表)
        else if(msg.matches("""^修改周[一二三四五]课表为：.*""".toRegex())) {
            val todayValue = msg.substring(8, msg.length)
            json[map[msg.substring(2, 4)]].asJsonObject.addProperty("value", todayValue)
            configFile.writeText(gson.toJson(json))
            group.sendMessage("修改成功")
        }

        //第二种修改方式     (获取当日周几修改)
        else if(msg.startsWith("修改今日课表为：")){
            val week = LocalDateTime.now().dayOfWeek.toString()
            val value = msg.substring(8, msg.length)
            if (json.has(week)) {
                json[week].asJsonObject.addProperty("value", value)
                group.sendMessage("修改成功")
            }
        }

        //第一种关闭课表方式     关闭指定日课表
        else if (msg.matches("""关闭周[一二三四五]课表""".toRegex())) {
            val day = msg.substring(2, 4)
            json.get(map[day]).asJsonObject.addProperty("Enable",false)
            group.sendMessage("已关闭${day}课表")
        }

        //第二种关闭课表方式  关闭当日课表
        else if (msg == "关闭今日课表"){
            val week = LocalDateTime.now().dayOfWeek.toString()
            if (json.has(week)) {
                json[week].asJsonObject.addProperty("Enable", false)
                group.sendMessage("已关闭今日课表")
            }
        }

        //第一种启用课表方式     指定启用周几课表

        else if (msg.matches("""启用周[一二三四五]课表""".toRegex())) {
            val day = msg.substring(2, 4)
            json[map[day]].asJsonObject.addProperty("Enable", true)
            group.sendMessage("已启用${day}课表")
        }

        //第二种启用课表方式     启用当日课表
        else if(msg == "启用今日课表"){
            val week = LocalDateTime.now().dayOfWeek.toString()
            if (json.has(week)) {
                json[week].asJsonObject.addProperty("Enable", true)
                configFile.writeText(gson.toJson(json))
                group.sendMessage("已启用今日课表")
            }
        }
        else {
            configFile.writeText(gson.toJson(json))
        }
    }
}

//时间相关
fun time(){
    val eventChannel = GlobalEventChannel.parentScope(Kcb)
    eventChannel.subscribeAlways<GroupMessageEvent> {
        when (message.contentToString()) {
            "now" -> {
                val time = LocalDateTime.now()
                group.sendMessage("现在时间: $time  ${time.dayOfWeek}")
                return@subscribeAlways
            }
            "开机时间" -> {
                group.sendMessage("开机时间为: $startTime")
            }
        }
    }
}

