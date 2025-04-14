package com.collection;

import javax.naming.event.ObjectChangeListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

class CricketPlayer{

    int playerID;
    String playerName;

    public CricketPlayer(int playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public int hashCode() {
//        return super.hashCode();
        return Objects.hash(this.playerID,this.playerName);
    }

    @Override
    public boolean equals(Object obj) {

        if(Objects.isNull(obj)){
            return false;
        }

        if(this == obj){
            return true;
        }

        CricketPlayer cricketPlayer = (CricketPlayer) obj;

        return playerID == cricketPlayer.getPlayerID() && Objects.equals(playerName, cricketPlayer.getPlayerName()) ;
//        return super.equals(obj);
    }
}

public class HashMapMenn {



    public static void main(String[] args){

//        Creating HashMap of string
//        HashMap<Integer, String> players = new HashMap<>();
//
//        for(int i=0;i<10;i++){
//            System.out.println(Objects.hash(i));
//        }
//
//        players.put(1,"Shreyas");
//        players.put(19,"Shreyas2");
//        players.put(3,"Virat");
//        players.put(4,"Rohit");
//        players.put(2,"Shubham");
//        players.put(4,"Shubman");
//
//        players = null;
//
//        System.gc();
//
//        System.out.println("HashMap 1 :: "+players);
//
//        CricketPlayer shr = new CricketPlayer(1, "Shreyas");
//        CricketPlayer shu = new CricketPlayer(2, "Shreyas");
//        CricketPlayer shr2 = new CricketPlayer(1, "Shreyas");
//
//        HashMap<CricketPlayer, String> players2 = new HashMap<>();
//        players2.put(shr, "Excellent Player");
//        players2.put(shu, "Fabulous Mindset");
//        players2.put(shr2, "Excellent Player");
//
//        System.out.println("HashMap 2 size :" +players2.size());


        //Sorted Hashmap
        TreeMap<Integer, String> sortedHashMap = new TreeMap<>();
        sortedHashMap.put(4,"Shreyas");
        sortedHashMap.put(3,"Shreyas");
        sortedHashMap.put(2,"Shreyas");

        System.out.println("First Index "+sortedHashMap.entrySet    ());
    }

}
