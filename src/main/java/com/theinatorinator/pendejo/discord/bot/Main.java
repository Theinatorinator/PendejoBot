package com.theinatorinator.pendejo.discord.bot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.*;
import com.theinatorinator.pendejo.discord.bot.eventlisteners.KeywordEventListener0;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * The main class
 */
public class Main {
    static int totalRunCount = 0;
    static JDA jda;
    static final Logger logger = Logger.getLogger("pendejoBot");
    static FileHandler fh;

    /**
     * @param args the args of the program, the format is token, followed by the guild id, followed by the owner id, followed by the @everyone perms id
     */
    public static void main(String @NotNull [] args) {
        try {
            RegisterAndConnect(args[0], args[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            fh = new FileHandler("C:/temp/test/pendejoBot.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
    }

    /**
     * @param token   the api token
     * @param guildId the guild id for the server this bot should be in
     * @throws Exception all exceptions get pushed back to the call in the main method
     */
    public static void RegisterAndConnect(String token, @NotNull String guildId) throws Exception {
        CommandClientBuilder builder = new CommandClientBuilder();
//        try {
//            builder.forceGuildOnly(guildId);
//
//        } catch (Exception e) {
//            System.out.println("INVALID GUILD ID");
//            e.printStackTrace();
//        }

        try {
            builder.setOwnerId("717398795746279476");
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
        //Makes a command handler
        CommandClient commandClient = builder.build();
        //build the jda instance
        jda = JDABuilder
                //token, and intents, don't change intents without updating your sharing links and intentions in the discord developer portal
                .create(
                        token,
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_MESSAGE_TYPING,
                        GatewayIntent.DIRECT_MESSAGES,
                        GatewayIntent.DIRECT_MESSAGE_TYPING
                )
                //register all of your event listeners here
                .addEventListeners(
                        new KeywordEventListener0()
                )
                //Don't touch any of this
                .addEventListeners(
                        commandClient
                )
                .setContextEnabled(true)
                .build();
        //touching allowed again

        jda.awaitReady();
        logger.info("Connected and online!");
        RandomStatus randomStatus = new RandomStatus(jda);
        randomStatus.MainFunction();
    }

    /**
     * @return returns the total number of time a command has been sent
     * note: the commands must be counted using the increasetotalruncount method
     */
    public static int getTotalRunCount() {
        return totalRunCount;
    }

    /**
     * increases the total run commands count by 1
     */
    public static void IncreaseTotalRunCount() {
        totalRunCount++;
    }

    public static JDA GetJDA() {
        return jda;
    }

}
