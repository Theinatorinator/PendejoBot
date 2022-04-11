package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions;

import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.functionutils.Replys;

/**
 * This class contains the functions and methods for the operation of the joke command
 * the joke command calls the joke-call method in the fishtails
 * the slash utils calls this method, which initializes a jokes object, the jokes object is in the function utils
 * this jokes class also has the function to return a random joke
 */
public class JokesFunction {
    /**
     * make a list of all your jokes here, they will be passed in with the constructor
     * the reply's class has methods and variables for replying with a quip or sentence, from a list passed in the constructor
     */
    final Replys replys = new Replys(
            "crisis averted",
            "wrape bad",
            "nerf wattson",
            "wrape dc",
            "swimsuit loba",
            "pendejo",
            "tittyfall"
    );

    /**
     * @return This function reply's with a random joke from the list of jokes passed in constructor
     */
    public String RandomJoke() {
        return replys.RandomReply();
    }
}
