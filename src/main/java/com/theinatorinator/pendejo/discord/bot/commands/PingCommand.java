package com.theinatorinator.pendejo.discord.bot.commands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

public class PingCommand extends SlashCommand {
    CommandUtils commandUtils = new CommandUtils();

    public PingCommand() {
        this.name = "joke";
        this.help = "tells you a joke";
    }

    @Override
    public void execute(SlashCommandEvent event) {
        event.reply(commandUtils.RandomJoke()).queue();
    }


}
