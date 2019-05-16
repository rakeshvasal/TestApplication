package com.rakeshvasal.testapplication.Java;

import java.util.List;

public class Team {
    public Object Players;
    public List<Player> playersList;
    private String Name_Short;
    private String Name_Full;

    public String getName_Short() {
        return Name_Short;
    }

    public void setName_Short(String Name_Short) {
        this.Name_Short = Name_Short;
    }

    public String getName_Full() {
        return Name_Full;
    }

    public void setName_Full(String Name_Full) {
        this.Name_Full = Name_Full;
    }

    /* public String getPlayers() {
         return Players;
     }

     public void setPlayers(String Players) {
         this.Players = Players;
     }
 */
    @Override
    public String toString() {
        return "ClassPojo [Name_Short = " + Name_Short + ", Name_Full = " + Name_Full + ", Players = " + "" + "]";
    }
}

