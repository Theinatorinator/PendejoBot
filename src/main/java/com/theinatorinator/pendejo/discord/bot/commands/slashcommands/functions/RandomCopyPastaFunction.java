package com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions;

import com.theinatorinator.pendejo.discord.bot.commands.slashcommands.functions.functionutils.Replys;

public class RandomCopyPastaFunction {

    final Replys replys = new Replys(
            "null",
            "pendejo",
            "meatsack"
    );

    public String RandomCopyPasta() {
        return replys.RandomReply();
    }
}
