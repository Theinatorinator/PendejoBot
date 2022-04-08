package com.theinatorinator.pendejo.discord.bot.eventlisteners;

import com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions.KeywordReply;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;


public class KeywordEventListener0 extends ListenerAdapter {
    KeywordReply keywordReply = new KeywordReply();

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message msg = event.getMessage();
        User user = event.getAuthor();
        String rawMsgContent = msg.getContentRaw().toUpperCase(Locale.ROOT);

        if (user.isBot()) return;

        keywordReply.CheckKeyword(user.getIdLong(), event.getChannel(), rawMsgContent);
    }
}
