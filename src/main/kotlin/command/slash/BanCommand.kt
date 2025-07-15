package io.github.codify.command.slash

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import net.dv8tion.jda.api.interactions.commands.build.Commands

object BanCommand : ISlashCommand {
    override fun reply(event: SlashCommandInteractionEvent) {
        event.reply("teste").queue()
    }

    override fun getCommandData(): CommandData {
        return Commands
            .slash("ban", "bane alguém")
    }
}