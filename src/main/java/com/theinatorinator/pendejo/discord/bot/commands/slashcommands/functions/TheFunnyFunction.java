package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions;

import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * function/backend for the funny function
 */
public class TheFunnyFunction {

    /**
     * @param channel the message channel that you want to send the messages in
     * @param times   the number of times you want to ping everyone with "pendejo jajaja"
     */
    public void PingEveryone(MessageChannel channel, Integer times) {
        Thread t = new Thread(() -> {
            for (int j = 0; j < times; j++) {
                channel.sendMessage("@everyone" + "pendejo jajaja").queue();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}
