package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;
import org.jetbrains.annotations.NotNull;

public class Joke extends SlashCommand {
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();

    public Joke() {
        this.name = "joke";
        this.help = "tells you a joke";
        this.userMissingPermMessage = "WHO THE FRICK TOLD YOU TO DO THIS, GO DO SOMETHING ELSE";
    }

    @Override
    public void execute(@NotNull SlashCommandEvent event) {
        event.reply(slashCommandUtils.JokeCall()).queue();
    }
}
