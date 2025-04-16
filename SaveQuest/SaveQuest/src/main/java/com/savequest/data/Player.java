package com.savequest.data;

import java.io.Serializable;

public class Player implements Serializable {

    private String playerId;
    private long bestScore;
    private int maxLevelReached;
    private boolean savedGame;
    private MathGame previouslySavedGame;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public long getBestScore() {
        return bestScore;
    }

    public void setBestScore(long bestScore) {
        this.bestScore = bestScore;
    }

    public int getMaxLevelReached() {
        return maxLevelReached;
    }

    public void setMaxLevelReached(int maxLevelReached) {
        this.maxLevelReached = maxLevelReached;
    }

    public boolean isSavedGame() {
        return savedGame;
    }

    public void setSavedGame(boolean savedGame) {
        this.savedGame = savedGame;
    }

    public MathGame getPreviouslySavedGame() {
        return previouslySavedGame;
    }

    public void setPreviouslySavedGame(MathGame previouslySavedGame) {
        this.previouslySavedGame = previouslySavedGame;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId='" + playerId + '\'' +
                ", bestScore=" + bestScore +
                ", maxLevelReached=" + maxLevelReached +
                ", savedGame=" + savedGame +
                ", previouslySavedGame=" + previouslySavedGame +
                '}';
    }
}
