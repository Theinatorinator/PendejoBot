package com.theinatorinator.pendejo.discord.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

import java.util.Random;

public class RandomStatus {
    JDA jda;

    public RandomStatus(JDA jda) {
        this.jda = jda;
    }

    public void MainFunction() {
        this.jda.getPresence().setPresence(Activity.listening("to systems boot"), false);
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep((long) (Math.random() * 100000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SetStatus();
                System.out.println("Updated the status");
            }
        });
        t.start();
    }

    private void SetStatus() {
        Random random = new Random();
        int toss = random.nextInt(11);
        switch (toss) {
            case 1 -> this.jda.getPresence().setPresence(Activity.watching("ur mom"), false);
            case 2 -> this.jda.getPresence().setPresence(Activity.playing("on the caustbox 5"), false);
            case 3 -> this.jda.getPresence().setPresence(Activity.listening("to the crys of wrape tryahrds after wingman nerf"), false);
            case 4 -> this.jda.getPresence().setPresence(Activity.competing("in the pendejo nationals"), false);
            case 5 -> this.jda.getPresence().setPresence(Activity.watching("causthicc put on his hazmat suit"), false);
            case 6 -> this.jda.getPresence().setPresence(Activity.playing("with wartcum body pillow"), false);
            case 7 -> this.jda.getPresence().setPresence(Activity.competing("in the circlejerk championships"), false);
            case 8 -> this.jda.getPresence().setPresence(Activity.playing("tittyfall (underrated gem)"), false);
            case 9 -> this.jda.getPresence().setPresence(Activity.watching("pendejo the movie"), false);
            case 10 -> this.jda.getPresence().setPresence(Activity.streaming("pendejo the movie", "https://www.reddit.com/r/apexcirclejerk/comments/oeb5nl/pendejo_jajaja_the_movie/"), false);
            default -> this.jda.getPresence().setPresence(Activity.watching("Wrape tryhards cry"), false);
        }

    }
}
