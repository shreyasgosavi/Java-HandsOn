package com.savequest.service;

import com.savequest.data.MathGame;
import com.savequest.data.Player;
import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

public class CalculateItRightGameImpl implements CalculateItRightGame {

    private Player player;
    private MathGame mathGame;
    private HashMap<String, Player> playersList = new HashMap<>();

    private File gameData;

    public CalculateItRightGameImpl() {

        //logic that will set the playersList from some file
        String userHome = System.getProperty("user.home");
        try {
            gameData = new File(userHome, "gameData.dat");
            gameData.createNewFile();

            if (gameData.length() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(gameData));
                playersList = (HashMap<String, Player>) objectInputStream.readObject();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Exception occurred");
            e.printStackTrace();
        }
    }

    @Override
    public void handleExistingPlayer(String playerID, BufferedReader bufferedInputStream) throws IOException {

        this.player = this.playersList.get(playerID);

        if (!Objects.isNull(this.player.getPreviouslySavedGame())) {
            System.out.println("Want to continue with previous un-finished game?? Y or N");
            boolean ans = bufferedInputStream.readLine().equalsIgnoreCase("Y");
            if (ans) {
                this.mathGame = this.player.getPreviouslySavedGame();
                return;
            }
        }
        this.mathGame = new MathGame();

    }

    @Override
    public void createNewPlayer(String playerID) {
        this.player = new Player();
        this.player.setPlayerId(playerID);
        this.mathGame = new MathGame();
    }

    @Override
    public void enterPlayerId() {

        try (BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in))) {

            boolean playAgain = true;
            System.out.println("Enter player-id");
            String playerID = bufferedInputStream.readLine();

            while (playAgain) {

                if (this.playersList.containsKey(playerID)) {
                    this.handleExistingPlayer(playerID, bufferedInputStream);
                } else {
                    this.createNewPlayer(playerID);
                }
                int returnValue = this.startTheGame(bufferedInputStream);

                if (returnValue == 1) {

                    System.out.println("Want to play again? -- Y or N");
                    playAgain = bufferedInputStream.readLine().equalsIgnoreCase("Y");
                    System.out.println(playAgain);
                    System.out.println("BYE");

                } else if (returnValue == 2) {
                    System.out.println("User Details saved successfully");
                    System.out.println("Final Player details");
                    System.out.println(this.player);
                    playAgain = false;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while reading player detail");
        } finally {
            System.out.println("Players Details read");
        }
    }

    @Override
    public void saveGame() {

        System.out.println("SAVING Players Details");
        if(this.mathGame.getLifeCount()>0) {
            this.player.setPreviouslySavedGame(this.mathGame);
            this.player.setSavedGame(true);
        }

        playersList.put(this.player.getPlayerId(), this.player);

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(gameData))) {
            objectOutputStream.writeObject(this.playersList);
        } catch (Exception e) {
            System.out.println("Issue while writing data into the file.");
            e.printStackTrace();
        }
    }

    @Override
    public void levelUP() {
        this.mathGame.setCurrentLevel(this.mathGame.getCurrentLevel() + 1);
        this.mathGame.setLevelQuestion(1);
        this.mathGame.setCurrentScore(this.mathGame.getCurrentScore() + 20);
        if (this.player.getBestScore() < this.mathGame.getCurrentScore()) {
            this.player.setBestScore(this.mathGame.getCurrentScore());
        }
        if (this.player.getMaxLevelReached() < this.mathGame.getCurrentLevel()) {
            this.player.setMaxLevelReached(this.mathGame.getCurrentLevel());
        }
    }

    @Override
    public int startTheGame(BufferedReader bufferedReader) throws IOException {

        //Welcome message based on game-status
        if (this.mathGame.getCurrentScore() > 0) {
            System.out.println("Continuing where you left-earlier");
            System.out.println("Score :: " + this.mathGame.getCurrentScore());
            System.out.println("Level :: " + this.mathGame.getCurrentLevel());
        } else {
            System.out.println("Let's begin");
            System.out.println("Player " + this.player.getPlayerId());
            System.out.println("Best Score " + this.player.getBestScore());
            System.out.println("Maximum level reached " + this.player.getMaxLevelReached());
        }

//        while(this.mathGame.getLifeCount() > 0) {

        System.out.println("Current Level :: " + (this.mathGame.getCurrentLevel()));
        int correctAnswer=0;
        boolean checkAnswer=true;

        do {

            if(checkAnswer) {
                System.out.println("You can save the game by entering SAVE in the answer");
                System.out.println("Question number " + (this.mathGame.getLevelQuestion()));
                correctAnswer = this.generateQuestion();
            }
            else{
                System.out.println("Try again !!");
            }

            String inputLine = "";

            try {
                inputLine = bufferedReader.readLine();
                if (inputLine.length() > 0 && inputLine.equals("SAVE")) {
                    this.saveGame();
                    return 2;
                }

                int userAnswer = Integer.parseInt(inputLine);
                checkAnswer = this.validateAnswer(correctAnswer, userAnswer);
                this.updateScore(checkAnswer);

                if (this.mathGame.getLevelQuestion() > 1 && (this.mathGame.getLevelQuestion() - 1) % 5 == 0) {
                    this.levelUP();
                    System.out.println("Congratulations you have moved to level :: " + (this.mathGame.getCurrentLevel()) + "!!");
                    System.out.println("Press any key to continue");
                    System.out.println("Life count :: " + this.mathGame.getLifeCount());
                    bufferedReader.readLine();
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Invalid input. Please enter a number or 'SAVE'.");
                checkAnswer = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (this.mathGame.getLifeCount() > 0);

        this.saveGame();
        System.out.println("GAME OVER !!");
        return 1;
    }

    @Override
    public int generateQuestion() {

        String[] operationArray = {"+", "-", "x"};

        Random random = new Random();
        int num1 = random.nextInt(50);
        int num2 = random.nextInt(50);
        int operation = random.nextInt(3);

        System.out.println("What is " + num1 + " " + operationArray[operation] + " " + num2);
        switch (operation) {
            case 0 -> {
                return num1 + num2;
            }
            case 1 -> {
                return num1 - num2;
            }
            case 2 -> {
                return num1 * num2;
            }
            default -> {
                return -1;
            }
        }

    }

    @Override
    public boolean validateAnswer(int ans, int userAnswer) {

        if (ans == userAnswer) {
            return true;
        }
        return false;
    }

    @Override
    public void updateScore(boolean checkAnswer) {

        if (checkAnswer) {
            System.out.println("CORRECT ANSWER !!!");
            this.mathGame.setCurrentScore(this.mathGame.getCurrentScore() + 10);
            this.mathGame.setLevelQuestion(this.mathGame.getLevelQuestion() + 1);
            if (this.player.getBestScore() < this.mathGame.getCurrentScore()) {
                this.player.setBestScore(this.mathGame.getCurrentScore());
            }
        } else {
            System.out.println("INCORRECT ANSWER !!!");
            this.mathGame.setLifeCount(this.mathGame.getLifeCount() - 1);
//            System.out.println("CORRECT ANSWER IS " + correctAns);
        }
        System.out.println("Score is :: " + this.mathGame.getCurrentScore());
        System.out.println("Life Count :: " + this.mathGame.getLifeCount());

    }
}
