package com.theinatorinator.pendejo.discord.bot;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.CopyPasta;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.Joke;
import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.TheFunni;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws Exception {
        RegisterAndConnect(args[0], args[1], args[2]);
    }

    public static void RegisterAndConnect(String token, String guildId, String ownerId) throws Exception {
        CommandClientBuilder builder = new CommandClientBuilder();

        if (guildId.isEmpty())
            throw new Exception("guild id is not PASSED IN, you must pass in -a if you do not want to limit guilds");
        if (ownerId.isEmpty()) throw new Exception("YOU MUST PASS IN A VALID GUILD ID TO CONTINUE");


        if (!guildId.matches("-a")) {
            try {
                builder.forceGuildOnly(guildId);
            } catch (Exception e) {
                System.out.println("INVALID GUILD ID");
            }
        }
        try {
            builder.setOwnerId(ownerId);
        } catch (Exception e) {
            System.out.println("ERROR, INVALID OWNER ID");
        }

        //register all your command classes here
        builder.addSlashCommands(
                new TheFunni(),
                new Joke(),
                new CopyPasta()
        );


        CommandClient commandClient = builder.build();

        JDA jda = JDABuilder
                .create(
                        token,
                        EnumSet.allOf(GatewayIntent.class)
                )
                .addEventListeners(
                        new EventListener(),
                        commandClient
                )
                .setContextEnabled(true)
                .build();

        jda.getPresence().setPresence(Activity.playing("your mom"), false);

        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            jda.getPresence().setPresence(Activity.watching("Your mom"), false);
        });

        t.start();
    }
}
