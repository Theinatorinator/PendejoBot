package com.theinatorinator.pendejo.discord.bot.commands.slashcommands;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.TheFunnyFunction;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils.SlashCommandUtils;
import org.jetbrains.annotations.NotNull;

public class TheFunni extends SlashCommand {
    TheFunnyFunction theFunnyFunction = new TheFunnyFunction();
    SlashCommandUtils slashCommandUtils = new SlashCommandUtils();
    public TheFunni() {
        this.name = "funni";
        this.help = "its a funni";
        this.userMissingPermMessage = "WHO THE FRICK TOLD YOU TO DO THIS, GO DO SOMETHING ELSE";
        this.defaultEnabled = false;
        this.enabledRoles = new String[]{"959660073678958602", "961816854102442095"};
        this.enabledUsers = new String[]{"717398795746279476"};
    }

    @Override
    public void execute(@NotNull SlashCommandEvent event) {
        slashCommandUtils.IncreaseCommandCount();
        event.reply("jajaja").queue();
        theFunnyFunction.PingEveryone(event.getChannel(), 10);
    }
}
