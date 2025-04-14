package com.savequest;

import com.savequest.service.CalculateItRightGame;
import com.savequest.service.CalculateItRightGameImpl;

public class SaveQuest {

    public static void main(String[] args) {

        CalculateItRightGame calculateItRightGame = new CalculateItRightGameImpl();

        System.out.println("BEGIN");
        calculateItRightGame.enterPlayerId();

    }
}
