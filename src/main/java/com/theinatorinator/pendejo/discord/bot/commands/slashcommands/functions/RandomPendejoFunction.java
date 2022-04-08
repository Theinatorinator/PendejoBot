package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions;

import net.dv8tion.jda.api.entities.MessageChannel;

import java.util.Random;

public class RandomPendejoFunction {

    public void SayRandomPendejo(MessageChannel channel, int times) {
        Thread t = new Thread(() -> {
            Random random = new Random();
            channel.sendMessage("pendejo").queue();
            for (int i = 0; i < times; i++) {
                try {
                    Thread.sleep(random.nextInt(6000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.sendMessage("pendejo").queue();
            }
        });
        t.start();
    }
}
