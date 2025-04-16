package com.savequest.service;

import com.savequest.data.MathGame;
import com.savequest.data.Player;

import java.io.BufferedReader;
import java.io.IOException;

public interface CalculateItRightGame {

    static void aboutCalculateItRightGame(){
        System.out.println("This interface gives the basic parts ");
    }

    void enterPlayerId();
    int startTheGame(BufferedReader bufferedReader) throws IOException;
    int generateQuestion();
    void validateAnswer(int ans, int userAns);

}
