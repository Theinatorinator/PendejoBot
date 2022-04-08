package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;

public class CopyPasta extends SlashCommand {
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();

    public CopyPasta() {
        this.name = "randomcopypasta";
        this.help = "Get a random Copy Pasta";
        this.userMissingPermMessage = "WHO THE FRICK TOLD YOU TO DO THIS, GO DO SOMETHING ELSE";
        this.cooldown = 10;
    }

    @Override
    protected void execute(SlashCommandEvent event) {
        event.reply(slashCommandUtils.RandomCopyPastaCall()).queue();
    }
}
