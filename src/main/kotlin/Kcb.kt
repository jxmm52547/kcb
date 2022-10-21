package xyz.jxmm

import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object Kcb : KotlinPlugin(
    JvmPluginDescription(
        id = "xyz.jxmm.kcb",
        name = "课程表",
        version = "0.1.2",
    ) {
        author("靖暄")
    }
) {
    override fun onEnable() {
        logger.info { "课程表插件加载成功" }
        main()
        kotlin.run { getCSC() }
        time()
    }
}