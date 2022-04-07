package com.theinatorinator.pendejo.discord.bot.commands;

import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.HashMap;
import java.util.Random;

public class CommandUtils {
    public String RandomJoke() {
        Random random = new Random();
        HashMap<Integer, String> jokes = new HashMap<>();

        jokes.put(1, "wrape bad");
        jokes.put(2, "nerf wattson");
        jokes.put(3, "wrape dc");
        jokes.put(4, "swimsuit loba");
        jokes.put(5, "pendejo");
        jokes.put(6, "tittyfall");
        jokes.put(7, "idk");
        jokes.put(8, "idk");
        jokes.put(9, "idk");
        jokes.put(10, "idk");

        int randomNum = random.nextInt(10 - 1);
        System.out.println(randomNum);
        String joke = jokes.get(randomNum);
        System.out.println(joke);
        return joke;
    }

    public String PendejoReply(Long userID, MessageChannel channel, double chance) {
        if (Math.random() >= chance) {
            channel.sendMessage("<@" + userID + ">" + "jajaja").queue();
            double rand = Math.random();
        }
        return "1";
    }
}
