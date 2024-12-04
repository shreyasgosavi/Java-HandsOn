package com.threading.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Locks {

    public static void main(String[] args) {

        Game furyTown = new Game();
        furyTown.setClanStrength(5);

        Runnable gameTask = new Runnable() {
            Random random = new Random();
            @Override
            public void run() {

                int i = random.nextInt(10);

                System.out.println(Thread.currentThread().getName() + " :: i == " + i);
                System.out.println(Thread.currentThread().getName() + " fight began");

                while (i < 9) {
                    synchronized (this) {
                        int enemies = furyTown.getEnemiesKilled();
                        System.out.println("Total enemies killed as of now " + enemies);
                        enemies++;
                        furyTown.setEnemiesKilled(enemies);
                        i = random.nextInt(10);
                    }
                    System.out.println(Thread.currentThread().getName() + " :: i == " + i);
                }
                furyTown.crewKilled();
            }
        };

        //Making Threads ready
        List<Thread> crews = new ArrayList<>();

        for (int i = 0; i < furyTown.getClanStrength(); i++) {
            String crewName = "crew_" + i;
            crews.add(new Thread(gameTask, crewName));
        }

        //Running threads
        crews.stream().forEach(
                Thread::start
        );

        crews.stream().forEach(crew -> {
            try {
                crew.join();
            } catch (Exception e) {
                System.out.println("Interrupted " + e);
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Final crew strength :: " + furyTown.getClanStrength());
        System.out.println("Enemies killed :: " + furyTown.getEnemiesKilled());

    }

}


class Game {
    private String clanName;
    private int levelReached;
    private int ratings;
    private int clanStrength;
    private int activeCrew;

    private int enemiesKilled;

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }

    public int crewKilled() {

        System.out.println(Thread.currentThread().getName() + " could not make it !");

        synchronized (this) {
            System.out.println("Before clan strength " + this.clanStrength);
            this.clanStrength--;
            System.out.println("After clan strength " + this.clanStrength);
        }
        return this.clanStrength;
    }


    public String getClanName() {
        return clanName;
    }

    public void setClanName(String clanName) {
        this.clanName = clanName;
    }

    public int getLevelReached() {
        return levelReached;
    }

    public void setLevelReached(int levelReached) {
        this.levelReached = levelReached;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public int getClanStrength() {
        return clanStrength;
    }

    public void setClanStrength(int clanStrength) {
        this.clanStrength = clanStrength;
    }

    public int getActiveCrew() {
        return activeCrew;
    }

    public void setActiveCrew(int activeCrew) {
        this.activeCrew = activeCrew;
    }
}