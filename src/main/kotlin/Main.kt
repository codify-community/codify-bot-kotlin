package io.github.codify

import io.github.codify.command.PrefixCommand
import io.github.codify.internal.BotEnv
import io.github.codify.internal.DatabaseConfig
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import java.util.EnumSet

fun main() {
    DatabaseConfig.connect()

    JDABuilder
        .createLight(BotEnv.token, EnumSet.allOf(GatewayIntent::class.java))
        .setStatus(OnlineStatus.DO_NOT_DISTURB)
        .setActivity(Activity.watching("Test Version"))
        .addEventListeners(
            //Slash commands


            //Prefix commands
            PrefixCommand()
        )
        .build()
}