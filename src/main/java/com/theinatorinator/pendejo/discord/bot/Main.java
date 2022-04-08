package com.theinatorinator.pendejo.discord.bot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.*;
import com.theinatorinator.pendejo.discord.bot.eventlisteners.KeywordEventListener0;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import java.util.EnumSet;

public class Main {
    static int totalRunCount = 0;

    public static void main(String @NotNull [] args) throws Exception {
        RegisterAndConnect(args[0], args[1], args[2]);
    }

    public static void RegisterAndConnect(String token, @NotNull String guildId, String ownerId) throws Exception {
        CommandClientBuilder builder = new CommandClientBuilder();

        if (guildId.isEmpty())
            throw new Exception("guild id is not PASSED IN, you must pass in -a if you do not want to limit guilds");
        if (ownerId.isEmpty()) throw new Exception("YOU MUST PASS IN A VALID GUILD ID TO CONTINUE");

        if (!guildId.matches("-a")) {
            try {
                builder.forceGuildOnly(guildId);
            } catch (Exception e) {
                System.out.println("INVALID GUILD ID");
                e.printStackTrace();
            }
        }
        try {
            builder.setOwnerId(ownerId);
        } catch (Exception e) {
            System.out.println("ERROR, INVALID OWNER ID");
            e.printStackTrace();
        }

        //register all your command classes here
        //To make a command, make a command class, and a function class to do something
        //to can use the command utils for special things, and the function is where you put classes that have information that may be used twice or doesn't make sense to be put into one class
        builder.addSlashCommands(
                new TheFunni(),
                new Joke(),
                new CopyPasta(),
                new RandomPendejo(),
                new TotalRunCommandsCount()
        );


        CommandClient commandClient = builder.build();


        JDA jda = JDABuilder
                .create(
                        token,
                        EnumSet.allOf(GatewayIntent.class)
                )
                //register all of your event listeners here
                .addEventListeners(
                        new KeywordEventListener0(),
                        commandClient
                )
                .setContextEnabled(true)
                .build();

        jda.getPresence().setPresence(Activity.playing("your mom"), false);

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //set the bots activity
            jda.getPresence().setPresence(Activity.watching("Your mom"), false);
        });

        t.start();
    }

    public static int getTotalRunCount() {
        return totalRunCount;
    }

    public static void IncreaseTotalRunCount() {
        totalRunCount++;
    }
}
