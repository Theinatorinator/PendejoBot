package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.JokesFunction;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;
import org.jetbrains.annotations.NotNull;

public class Joke extends SlashCommand {
    JokesFunction jokesFunction = new JokesFunction();
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();
    public Joke() {
        this.name = "joke";
        this.help = "tells you a joke";
        this.userMissingPermMessage = "Go do something else";
    }

    @Override
    public void execute(@NotNull SlashCommandEvent event) {
        slashCommandUtils.IncreaseCommandCount();
        event.reply(jokesFunction.RandomJoke()).queue();
    }
}
