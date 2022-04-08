package com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions;

import net.dv8tion.jda.api.entities.MessageChannel;

public class KeywordReply {
    public void CheckKeyword(Long userID, MessageChannel channel, String rawMsgContent) {
        switch (rawMsgContent) {
            case "PENDEJO":
                ReplyToKeyword(userID, channel, 0.5, true, "jajaja");
                return;
            case "JAJAJA":
                ReplyToKeyword(userID, channel, 0.5, true, "pendejo");
                return;
            case "WATSON":
                ReplyToKeyword(userID, channel, 0.5, true, "watcum");
            default:
                try {
                    throw new Exception("Keyword was in keyword list but not in keyword actian table");
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    }

    public void ReplyToKeyword(Long userID, MessageChannel channel, double chance, boolean mention, String message) {
        if (Math.random() >= chance) {
            if (mention) {
                channel.sendMessage("<@" + userID + ">" + message).queue();
            } else {
                channel.sendMessage(message).queue();
            }
        }
    }
}
