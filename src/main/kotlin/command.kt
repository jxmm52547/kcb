package org.jxmm.kcb

import org.jxmm.kcb.*
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.ConsoleCommandSender
import net.mamoe.mirai.console.command.UserCommandSender
import net.mamoe.mirai.console.permission.AbstractPermitteeId
import net.mamoe.mirai.console.permission.PermissionService.Companion.permit

object Command : CompositeCommand(
    PluginMain,
"kcb",
){
    @SubCommand("change")
    suspend fun UserCommandSender.change(){

    }
    @SubCommand("test")
    suspend fun UserCommandSender.test(){
        subject.sendMessage("指令完成")
    }
}