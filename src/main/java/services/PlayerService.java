package services;

import exceptions.PlayerAlreadyRegistered;

public interface PlayerService {
    
    int createPlayerObject(String playerId, String playerName, int playerAge, String playerGender, int teamId) throws PlayerAlreadyRegistered;

}
