package com.example.questionanddrink;

public class players {

    private String playerID;
    private String name;
    private Integer points;

    public players(String ID, String Name, Integer Points){
        playerID = ID;
        name = Name;
        points = Points;
    }

    public String getPlayerID(){
        return playerID;
    }
    public String getname(){
        return name;
    }
    public Integer getPoints(){
        return points;
    }
}
