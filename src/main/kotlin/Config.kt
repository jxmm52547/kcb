package org.jxmm.kcb

import kotlinx.serialization.Serializable
import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.value
import net.mamoe.mirai.console.data.AutoSavePluginData
import kotlinx.serialization.*
import kotlinx.serialization.json.*

object Config : AutoSavePluginConfig("config") {
    val admin : MutableList<Long> by value()
}

object weekStudy : AutoSavePluginData("weekStudy"){
    var wd1:String by value()
    var wd2:String by value()
    var wd3:String by value()
    var wd4:String by value()
    var wd5:String by value()
}
val kb1 = weekStudy.wd1
val kb2 = weekStudy.wd2
val kb3 = weekStudy.wd3
val kb4 = weekStudy.wd4
val kb5 = weekStudy.wd5