package dao;

import exceptions.PlayerAlreadyRegistered;
import models.Player;

public interface PlayerDao {
    
    int createPlayers(Player player) throws PlayerAlreadyRegistered;
}
