package io.github.codify.command

import io.github.codify.command.slash.BanCommand
import io.github.codify.command.slash.ISlashCommand
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.build.CommandData

class SlashHandler : ListenerAdapter() {
    private val commands = mapOf<String, ISlashCommand>(
        "ban" to BanCommand
    )

    override fun onReady(event: ReadyEvent) {
        val dataList = listOf<CommandData>(
            BanCommand.getCommandData()
        )

        event.jda.updateCommands().addCommands(dataList).queue()
    }

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        val eventName = event.name
        commands[eventName]?.reply(event)
    }
}