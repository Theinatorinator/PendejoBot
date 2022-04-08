package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.slashutils;

import com.theinatorinator.pendejo.discord.bot.Main;

/**
 * This class is where you put all the command call methods, in you command you should reply to the command and call a method from this class
 * the method in this class should then do the work of the function, or reply  with an object to send in the reply
 * This will keep the command classes rather clean and empty
 */
public class SlashCommandUtils {

    public int TotalCommandCount() {
        return Main.getTotalRunCount();
    }

    public void IncreaseCommandCount() {
        Main.IncreaseTotalRunCount();
        System.out.println(Main.getTotalRunCount());
    }


}
