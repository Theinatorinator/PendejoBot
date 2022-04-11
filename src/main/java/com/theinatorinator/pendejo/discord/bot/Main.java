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

/**
 * The main class
 */
public class Main {
    static int totalRunCount = 0;

    /**
     * @param args the args of the program, the format is token, followed by the guild id, followed by the owner id, followed by the @everyone perms id
     */
    public static void main(String @NotNull [] args) {
        try {
            RegisterAndConnect(args[0], args[1], args[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param token   the api token
     * @param guildId the guild id for the server this bot should be in
     * @param ownerId the owner id for this bot
     * @throws Exception all exceptions get pushed back to the call in the main method
     */
    public static void RegisterAndConnect(String token, @NotNull String guildId, String ownerId) throws Exception {
        CommandClientBuilder builder = new CommandClientBuilder();

        if (guildId.isEmpty())
            throw new Exception("guild id is not PASSED IN, you must pass in -a if you do not want to limit guilds");
        if (ownerId.isEmpty()) throw new Exception("YOU MUST PASS IN A VALID GUILD ID TO CONTINUE");


        try {
            builder.forceGuildOnly(guildId);

        } catch (Exception e) {
            System.out.println("INVALID GUILD ID");
            e.printStackTrace();
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
                        GatewayIntent.GUILD_MESSAGES,
                        GatewayIntent.GUILD_MEMBERS,
                        GatewayIntent.GUILD_MESSAGE_REACTIONS,
                        GatewayIntent.GUILD_MESSAGE_TYPING
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
}
