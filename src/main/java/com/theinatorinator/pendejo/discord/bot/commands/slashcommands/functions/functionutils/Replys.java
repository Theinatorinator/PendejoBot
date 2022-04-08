package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.functionutils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * the reply's class has methods and variables for replying with a quip or sentence, from a list passed in the constructor
 */
public class Replys {
    final HashMap<Integer, String> jokes = new HashMap<>();
    final Random random = new Random();
    int totalJokes = 0;
    final Logger logger = Logger.getLogger("pendejoBot");
    FileHandler fh;

    /**
     * @param args The list of reply that you want to be said
     */
    public Replys(String @NotNull ... args) {
        for (int i = 0; i < args.length; i++) {
            jokes.put(i, args[i]);
            totalJokes = i;
        }
        try {
            fh = new FileHandler("C:/temp/test/pendejoBot.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);

        logger.info("DEBUG: Initialized a reply's list with reply's" + Arrays.toString(args));
    }

    /**
     * @return returns a random Reply from the list passed in the args of the constructor
     */
    public String RandomReply() {
        int randomNum = random.nextInt(totalJokes + 1);
        String joke = jokes.get(randomNum);
        System.out.println(joke);
        return joke;
    }

    /**
     * @return returns all the Reply's stored as and array of strings
     */
    public String[] AllPossibleReplys() {
        return jokes.values().toArray(new String[totalJokes]);
    }

}
