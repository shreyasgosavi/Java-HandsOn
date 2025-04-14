package com.savequest.service;

import com.savequest.data.MathGame;
import com.savequest.data.Player;
import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;

public class CalculateItRightGameImpl implements CalculateItRightGame{

    private Player player;
    private MathGame mathGame;

    private HashMap<String,Player> playersList = new HashMap<>();

//    CalculateItRightGameImpl(){
//
//        //logic that will set the playersList from some file
//    }

    public void handleExistingPlayer(String playerID, BufferedReader bufferedInputStream) throws IOException {

        this.player = this.playersList.get(playerID);

        if (!Objects.isNull(this.player.getPreviouslySavedGame())) {
            System.out.println("Want to continue with previous un-finished game?? Y or N");
            boolean ans = bufferedInputStream.readLine().equalsIgnoreCase("Y");
            if (ans) {
                this.mathGame = this.player.getPreviouslySavedGame();
            } else {
                this.mathGame = new MathGame();
            }
        }
        else{
            this.mathGame = new MathGame();
        }
    }

    public void createNewPlayer(String playerID){
        this.player = new Player();
        this.player.setPlayerId(playerID);
        this.mathGame = new MathGame();
    }

    public String readUserInput(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
    }

    @Override
    public void enterPlayerId() {

        try(BufferedReader bufferedInputStream = new BufferedReader(new InputStreamReader(System.in))) {

            boolean playAgain = true;
            System.out.println("Enter player-id");
            String playerID = bufferedInputStream.readLine();

            while(playAgain) {

                if (this.playersList.containsKey(playerID)) {
                    this.handleExistingPlayer(playerID,bufferedInputStream);
                } else {
                    this.createNewPlayer(playerID);
                }
                int returnValue = this.startTheGame(bufferedInputStream);

                if(returnValue == 1) {
                    System.out.println("Want to play again? -- Y or N");
                    this.player.setSavedGame(false);
                    this.player.setPreviouslySavedGame(null);
                    playAgain = bufferedInputStream.readLine().equalsIgnoreCase("Y");
                    System.out.println(playAgain);
                }
                else if(returnValue == 2){
                    System.out.println("User Details saved successfully");
                    System.out.println("Final Player details");
                    playersList.values().forEach((a)->{
                        System.out.println(a);
                    });
                    playAgain=false;

                }
                else{
                    System.out.println("Return value :: "+returnValue);
                    playAgain=false;
                }
            }


        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error occurred while reading player detail");
        }finally{
            System.out.println("Players Details read");
        }
    }

    public void saveGame(){
        System.out.println("SAVING Players Details");
        this.player.setPreviouslySavedGame(this.mathGame);
        this.player.setSavedGame(true);
        playersList.put(this.player.getPlayerId(), this.player);
    }

    public void levelUP(){
        this.mathGame.setCurrentLevel(this.mathGame.getCurrentLevel() + 1);
        this.mathGame.setLevelQuestion(1);
        this.mathGame.setCurrentScore(this.mathGame.getCurrentScore() + 20);
        if (this.player.getBestScore() < this.mathGame.getCurrentScore()) {
            this.player.setBestScore(this.mathGame.getCurrentScore());
        }

        if(this.player.getMaxLevelReached() < this.mathGame.getCurrentLevel()){
            this.player.setMaxLevelReached(this.mathGame.getCurrentLevel());
        }
    }

    @Override
    public int startTheGame(BufferedReader bufferedReader) throws IOException {

        if(this.mathGame.getCurrentScore() > 0){
            System.out.println("Continuing where you left-earlier");
        }else{
            System.out.println("Let's begin");
        }

        while(this.mathGame.getLifeCount() > 0) {

            System.out.println("Current Level :: "+(this.mathGame.getCurrentLevel()));

            for (int i = this.mathGame.getLevelQuestion(); i < 6; i++) {

                System.out.println("You can save the game by entering SAVE in the answer");
                System.out.println("Question number "+(this.mathGame.getLevelQuestion()));
                int ans = this.generateQuestion();

                String saveGame="";
                String inputLine="";

                try {
                    inputLine = bufferedReader.readLine();
                    saveGame = inputLine;
                    if (saveGame.length() > 0 && saveGame.equals("SAVE")) {
                        this.saveGame();
                        return 2;
                    }

                    int userAnswer = Integer.parseInt(inputLine);
                    if(this.validateAnswer(ans, userAnswer)){
                        System.out.println("GAME OVER !!");
                        return 1;
                    }

                }catch(NumberFormatException numberFormatException){
                    System.out.println("Invalid input. Please enter a number or 'SAVE'.");
                    numberFormatException.printStackTrace();
                    continue;
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

            this.levelUP();

            System.out.println("Congratulations you have moved to level :: " + (this.mathGame.getCurrentLevel()+1 )+ "!! Press any key to continue");
            System.out.println("Life count :: "+this.mathGame.getLifeCount());
            bufferedReader.readLine();

        }

        return -1;
    }

    @Override
    public int generateQuestion() {

        String[] operationArray = {"+","-","x"};

        Random random = new Random();
        int num1 = random.nextInt(50);
        int num2 = random.nextInt(50);
        int operation = random.nextInt(3);

        System.out.println("What is "+num1 +" "+operationArray[operation]+" "+num2);
        switch(operation){
            case 0 -> {
                return num1+num2;
            }
            case 1 -> {
                return num1-num2;
            }
            case 2-> {
                return num1*num2;
            }
            default -> {return -1;}
        }

    }

    @Override
    public boolean validateAnswer(int ans,int userAnswer) {

        if(ans == userAnswer){
            System.out.println("CORRECT ANSWER !!!");
            this.mathGame.setCurrentScore(this.mathGame.getCurrentScore()+10);
            if(this.player.getBestScore() < this.mathGame.getCurrentScore()){
                this.player.setBestScore(this.mathGame.getCurrentScore());
            }
        }else{
            System.out.println("INCORRECT ANSWER !!!");
            System.out.println("CORRECT ANSWER IS "+ans);
            this.mathGame.setLifeCount(this.mathGame.getLifeCount()-1);
        }
        this.mathGame.setLevelQuestion(this.mathGame.getLevelQuestion()+1);
        System.out.println("Score is :: "+this.mathGame.getCurrentScore());
        System.out.println("Life Count :: "+this.mathGame.getLifeCount());

        if(this.mathGame.getLifeCount()==0){
            return true;
        }
        return false;
    }
}
