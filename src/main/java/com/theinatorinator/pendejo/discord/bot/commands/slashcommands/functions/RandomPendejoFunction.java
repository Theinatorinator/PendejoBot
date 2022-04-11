package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions;

import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Random;

/**
 * Functions/backend for the randompendejo command
 */
public class RandomPendejoFunction {

    /**
     * @param channel the channel to say pendejo in
     * @param times   the number of times to say pendejo in
     * @param bound   the upper bound of time to randomly say pendejo at
     */
    public void SayRandomPendejo(MessageChannel channel, int times, int bound) {
        Thread t = new Thread(() -> {
            Random random = new Random();
            channel.sendMessage("pendejo").queue();
            for (int i = 0; i < times; i++) {
                try {
                    Thread.sleep(random.nextInt(bound));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.sendMessage("pendejo").queue();
            }
        });
        t.start();
    }
}
