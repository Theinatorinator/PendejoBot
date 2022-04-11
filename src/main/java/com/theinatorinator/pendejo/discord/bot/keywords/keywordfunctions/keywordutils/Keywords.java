package com.theinatorinator.pendejo.discord.bot.keywords.keywordfunctions.keywordutils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class creates and stores a list of words, which can then be checked against
 * passed in strings in the constructor will be stored and then can be checked and manipulated with the other methods in the class
 */
public class Keywords {
    final HashMap<Integer, String> keywords = new HashMap<>();
    final Logger logger = Logger.getLogger("pendejoBot");
    FileHandler fh;

    /**
     * @param args pass in the keywords that you want to be checked against, this wil simply return true if they are in the list passed in the args
     */
    public Keywords(String @NotNull ... args) {
        for (int i = 0; i < args.length; i++) {
            keywords.put(i, args[i]);
        }
        try {
            fh = new FileHandler("C:/temp/test/pendejoBot.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        logger.info("DEBUG: Initialized the keywords list with jokes" + Arrays.toString(args));
    }

    /**
     * @param rawMessage Input the raw message that you want to check against your keywords, entered during the construction
     * @return returns true if the passed in rawMessage is on the list of keywords
     */
    public boolean IsValid(String rawMessage) {
        return true;
    }
}
