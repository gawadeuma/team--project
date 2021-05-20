package models;

public class Player {
    private String playerId;
    private String playerName;
    private int playerAge;
    private String playerGender;
    private int teamId;

    public Player() {
        super();
    }

    public Player(String playerId, String playerName, int playerAge, String playerGender, int teamId) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.playerGender = playerGender;
        this.teamId = teamId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public String getPlayerGender() {
        return playerGender;
    }

    public void setPlayerGender(String playerGender) {
        this.playerGender = playerGender;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

}
