package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.TheFunnyFunction;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;
import org.jetbrains.annotations.NotNull;

/**
 * class for a command that pings everyone multiple times with pendejo
 */
public class TheFunni extends SlashCommand {
    TheFunnyFunction theFunnyFunction = new TheFunnyFunction();
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();

    /**
     * The command constructor as detailed in the SlashCommand docs
     */
    public TheFunni() {
        this.name = "funni";
        this.help = "its a funni";
        this.userMissingPermMessage = "Get yo hands off this commands";
        this.defaultEnabled = true;
        //allow the reddit mods role in the apex circle jerk server to use this command
        this.enabledRoles = new String[]{"959660073678958602"};
        //allow me to use this command
        this.enabledUsers = new String[]{"717398795746279476", "221313820847636491"};
    }

    @Override
    public void execute(@NotNull SlashCommandEvent event) {
        slashCommandUtils.IncreaseCommandCount();
        event.reply("jajaja").queue();
        theFunnyFunction.PingEveryone(event.getChannel(), 10);
    }
}
