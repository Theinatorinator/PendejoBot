package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.RandomPendejoFunction;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;
import org.jetbrains.annotations.NotNull;

/**
 * Slash command class for to randomly say pendejo over a period of time
 */
public class RandomPendejo extends SlashCommand {
    RandomPendejoFunction randomPendejoFunction = new RandomPendejoFunction();
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();

    /**
     * Constructor for the random pendejo command as detailed in the SlashCommand doc
     */
    public RandomPendejo() {
        this.name = "randompendejo";
        this.help = "Gets a random pendejo";
    }

    @Override
    protected void execute(@NotNull SlashCommandEvent event) {
        slashCommandUtils.IncreaseCommandCount();
        event.reply("certified jajaja moment").queue();
        randomPendejoFunction.SayRandomPendejo(event.getChannel(), 10, 60000);
    }
}
