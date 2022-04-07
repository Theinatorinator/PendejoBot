package com.theinatorinator.pendejo.discord.bot;

import com.theinatorinator.pendejo.discord.bot.commands.CommandUtils;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;


public class EventListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        CommandUtils commandUtils = new CommandUtils();

        Message msg = event.getMessage();
        User user = event.getAuthor();
        if (msg.getContentRaw().equals("pendejo")) {
            commandUtils.PendejoReply(user.getIdLong(), event.getChannel(), 0.5);
        }
    }
}
