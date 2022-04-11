package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.RandomCopyPastaFunction;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;
import org.jetbrains.annotations.NotNull;

/**
 * This class is a simple slash command to return a random copy-pasta
 */
public class CopyPasta extends SlashCommand {
    RandomCopyPastaFunction randomCopyPastaFunction = new RandomCopyPastaFunction();
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();

    /**
     * The class consroctour, which assigns traits of the command
     * mor documentation can be found from the extended SlashCommand
     */
    public CopyPasta() {
        this.name = "randomcopypasta";
        this.help = "Get a random Copy Pasta";
        this.userMissingPermMessage = "WHO THE FRICK TOLD YOU TO DO THIS, GO DO SOMETHING ELSE";
        this.cooldown = 10;
    }

    @Override
    protected void execute(@NotNull SlashCommandEvent event) {
        slashCommandUtils.IncreaseCommandCount();
        event.reply(randomCopyPastaFunction.RandomCopyPasta()).queue();
    }
}
