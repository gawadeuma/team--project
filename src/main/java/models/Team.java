package models;

import java.io.Serializable;
import java.util.List;

public class Team implements Serializable {
    private int teamId;
    private String teamName;
    private List<Player> players;

    public Team() {
        super();
    }

    public Team(int teamId, String teamName, List<Player> players) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.players = players;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
