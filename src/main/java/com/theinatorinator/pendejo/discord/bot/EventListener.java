package com.theinatorinator.pendejo.discord.bot;

import com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions.KeywordReply;
import com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions.keywordutils.Keywords;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.util.Locale;


public class EventListener extends ListenerAdapter {
    KeywordReply keywordReply = new KeywordReply();
    final Keywords keywords = new Keywords(
            "PENDEJO",
            "JAJAJA",
            "WATSON"
    );

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        User user = event.getAuthor();
        String rawMsgContent = msg.getContentRaw().toUpperCase(Locale.ROOT);

        if (!keywords.IsValid(rawMsgContent)) return;
        keywordReply.CheckKeyword(user.getIdLong(), event.getChannel(), rawMsgContent);
    }
}
