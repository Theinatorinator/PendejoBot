package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;

public class TotalRunCommandsCount extends SlashCommand {
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();

    public TotalRunCommandsCount() {
        this.name = ("totalruncommandscount");
        this.help = ("Gets the total number of times a command was run in this instance");
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        slashCommandUtils.IncreaseCommandCount();
        event.reply(Integer.toString(slashCommandUtils.TotalCommandCount())).queue();
    }
}
