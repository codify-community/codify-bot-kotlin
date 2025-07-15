package io.github.codify.command.usecase

import io.github.codify.command.prefix.IPrefixCommand
import io.github.codify.command.slash.ISlashCommand
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.interactions.commands.build.CommandData

object BanUseCase : IPrefixCommand, ISlashCommand {
    override fun response(event: MessageReceivedEvent) {
        TODO("Not yet implemented")
    }

    override fun reply(event: SlashCommandInteractionEvent) {
        TODO("Not yet implemented")
    }

    override fun getCommandData(): CommandData {
        TODO("Not yet implemented")
    }

    fun ban() {

    }
}