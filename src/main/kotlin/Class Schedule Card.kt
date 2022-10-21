package xyz.jxmm

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import net.mamoe.mirai.utils.info
import xyz.jxmm.Kcb.logger
import java.io.File


val gson: Gson = GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create()


fun main() {
    val jsonGen = JsonObject().apply {
        this.add("MONDAY", createDay("周一"))
        this.add("TUESDAY", createDay("周二"))
        this.add("WEDNESDAY", createDay("周三"))
        this.add("THURSDAY", createDay("周四"))
        this.add("FRIDAY", createDay("周五"))
        this.add("SATURDAY", createDay("周六"))
        this.add("SUNDAY", createDay("周日"))
    }

    if (configFile.exists()){
        logger.info { "已存在课程表,取消创建" }
        logger.info { "课表加载完毕" }
    } else{
        logger.info { "未检测到课程表,正在为您创建,请等待" }
        Thread.sleep(2_000)
        File("./kcb_data/").mkdirs()
        configFile.writeText(gson.toJson(jsonGen))
        logger.info{"课表创建完毕"}
    }

}

fun createDay(day: String): JsonObject {
    return JsonObject().apply {
        this.addProperty("Enable", true)
        this.addProperty("value", "${day}课表")
    }
}