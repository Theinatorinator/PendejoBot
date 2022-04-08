package com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions;

import com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions.keywordutils.Keywords;
import net.dv8tion.jda.api.entities.MessageChannel;

public class KeywordReply {
    final Keywords keywords = new Keywords(
            "PENDEJO",
            "JAJAJA",
            "WATSON"
    );

    public void CheckKeyword(Long userID, MessageChannel channel, String rawMsgContent) {
        if (!keywords.IsValid(rawMsgContent)) return;
        switch (rawMsgContent) {
            case "PENDEJO":
                ReplyToKeyword(userID, channel, 0.0, true, "jajaja");
                return;
            case "JAJAJA":
                ReplyToKeyword(userID, channel, 0.0, true, "pendejo");
                return;
            case "WATSON":
                ReplyToKeyword(userID, channel, 0.0, true, "watcum");
                return;
            default:
                try {
                    throw new Exception("Keyword was in keyword list but not in keyword action table");
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
