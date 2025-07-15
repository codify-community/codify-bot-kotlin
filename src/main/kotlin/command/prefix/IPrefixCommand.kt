package io.github.codify.command.prefix

import net.dv8tion.jda.api.events.message.MessageReceivedEvent

interface IPrefixCommand {
    fun response(event: MessageReceivedEvent)
}