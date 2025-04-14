package com.savequest.data;

public class MathGame {

    private int lifeCount=3;
    private int currentScore;
    private int currentLevel=1;
    private int levelQuestion=1;


    public int getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public int getLevelQuestion() {
        return levelQuestion;
    }

    public void setLevelQuestion(int levelQuestion) {
        this.levelQuestion = levelQuestion;
    }
}
