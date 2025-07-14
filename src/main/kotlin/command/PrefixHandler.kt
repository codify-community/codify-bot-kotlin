package io.github.codify.command

import io.github.codify.command.prefix.BanCommand
import io.github.codify.command.prefix.IPrefixCommand
import io.github.codify.command.prefix.KickCommand
import io.github.codify.command.prefix.RegisterCommand
import io.github.codify.internal.BotEnv
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class PrefixHandler : ListenerAdapter() {
    private val commands = mapOf<String, IPrefixCommand>(
        "register" to RegisterCommand,
        "ban" to BanCommand,
        "kick" to KickCommand
    )

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val content = event.message.contentRaw
        if(content.startsWith(BotEnv.PREFIX)) {
            val commandWithArgs = content.substring(BotEnv.PREFIX.length).split(" ")[0]
            commands[commandWithArgs]?.response(event)
        }
    }
}