package io.github.codify.command

import io.github.codify.command.prefix.IPrefix
import io.github.codify.command.prefix.RegisterCommand
import io.github.codify.internal.BotEnv
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class PrefixCommand : ListenerAdapter() {
    private val commands = mapOf<String, IPrefix>(
        "register" to RegisterCommand()
    )

    override fun onMessageReceived(event: MessageReceivedEvent) {
        val content = event.message.contentRaw
        if(content.startsWith(BotEnv.PREFIX)) {
            commands[content.substring(BotEnv.PREFIX.length)]?.respondTo(event)
        }
    }
}