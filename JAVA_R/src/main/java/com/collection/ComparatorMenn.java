package com.collection;

import java.util.*;

class Player{

    private String name;
    private int average;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public Player(String name, int average) {
        this.name = name;
        this.average = average;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", average=" + average +
                '}';
    }
}

public class ComparatorMenn {

    public static void main(String[] args) {


        Player shreyas = new Player("Shreyas", 98);
        Player shubham = new Player("Shubham", 95);

        List<Player> players = Arrays.asList(shreyas, shubham);

        players.sort((player1, player2)-> player2.getAverage()-player1.getAverage());

        System.out.println(players);

        //Indexed, Maintains insertion order
        List<String> aList = new ArrayList<>();
        aList.add("SHR");
        aList.add("SHR3");
        aList.add("SHR2");

        //Non-indexed, maintains insertion order, independent nodes pointing to one another
        List<String> aLinkedList = new LinkedList<>();
        aLinkedList.add("SHR1");
        aLinkedList.add("SHR2");
        aLinkedList.add("SHR3");
        aLinkedList.add("SHR4");

        System.out.println(aLinkedList.subList(3,4));


        //Legacy Collection Implementation that is thread-safe, rest functionlity is same
        List<String> aVector = new Vector<>();
        aVector.add("SHR1");
        aVector.add("SHR2");
        aVector.add("SHR3");
        aVector.add("SHR4");

        Stack<String> aStack = new Stack<>();
        aStack.push("SHR1");
        aStack.push("SHR2");
        aStack.push("SHR3");
        aStack.push("SHR4");

        aStack.peek();
        aStack.pop();
        System.out.println(aStack);




    }
}

