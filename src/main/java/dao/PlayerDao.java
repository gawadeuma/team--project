package dao;

import exceptions.PlayerAlreadyRegistered;
import models.Player;

import java.util.List;

public interface PlayerDao {
    
    int createPlayers(Player player) throws PlayerAlreadyRegistered;

    List<Player> getPLayers(int teamId);
}
