package com.theinatorinator.pendejo.discord.bot;

import com.theinatorinator.pendejo.discord.bot.commands.PingCommand;
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

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

        builder.addSlashCommand(new PingCommand());
        CommandClient commandClient = builder.build();
        JDA jda = JDABuilder.createDefault(token).addEventListeners(new EventListener(), commandClient).build();

    }
}
