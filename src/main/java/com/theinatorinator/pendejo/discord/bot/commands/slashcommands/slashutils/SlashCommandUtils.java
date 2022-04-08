package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils;

import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.JokesFunction;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.RandomCopyPastaFunction;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.TheFunnyFunction;
import net.dv8tion.jda.api.entities.MessageChannel;

/**
 * This class is where you put all the command call methods, in you command you should reply to the command and call a method from this class
 * the method in this class should then do the work of the function, or reply  with an object to send in the reply
 * This will keep the command classes rather clean and empty
 */
public class SlashCommandUtils {
    TheFunnyFunction funnyUtil = new TheFunnyFunction();
    JokesFunction jokesFunctions = new JokesFunction();
    RandomCopyPastaFunction randomCopyPastaFunction = new RandomCopyPastaFunction();

    public void TheFunniCall(MessageChannel channel) {
        Thread t = new Thread(() -> funnyUtil.PingEveryone(channel, 10));
        t.start();
    }

    public String JokeCall() {
        return jokesFunctions.RandomJoke();
    }

    public String RandomCopyPastaCall() {
        return randomCopyPastaFunction.RandomCopyPasta();
    }
}
