package com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions;

import com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions.keywordutils.Keywords;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * This class is part of hte automated keyword reply
 * Right now this reply's to any keyword, where it is the only word in the message
 */
public class KeywordReply {
    final Keywords keywords = new Keywords(
            "PENDEJO",
            "JAJAJA",
            "WATSON"
    );

    /**
     * @param userID        The user id of the person that sent the message
     * @param channel       The message channel where the message was sent
     * @param rawMsgContent The raw message content
     */
    public void CheckKeyword(Long userID, MessageChannel channel, String rawMsgContent) {
        if (!keywords.IsValid(rawMsgContent)) return;

        if (rawMsgContent.contains("PENDEJO")) {
            ReplyToKeyword(userID, channel, 0.0, true, "jajaja");
        }
        if (rawMsgContent.contains("JAJAJA")) {
            ReplyToKeyword(userID, channel, 0.0, true, "pendejo");
        }
        if (rawMsgContent.contains("WATSON")) {
            ReplyToKeyword(userID, channel, 0.0, true, "watcum");
        }
    }

    /**
     * This method reply's to a user based on the passed in information
     *
     * @param userID  The userid to be mentioned in the reply
     * @param channel The channel where the keyword was
     * @param chance  The chance that the reply happens, the higher the number thw lower the chance , between 0 and 1 with 0 being 100% and 1 being 0%
     * @param mention boolean of whether the to mention the user in the reply
     * @param message The message to send in the reply
     */
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
