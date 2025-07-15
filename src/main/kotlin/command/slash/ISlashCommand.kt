package io.github.codify.command.slash

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.interactions.commands.build.CommandData

interface ISlashCommand {
    fun reply(event: SlashCommandInteractionEvent)

    fun getCommandData(): CommandData
}