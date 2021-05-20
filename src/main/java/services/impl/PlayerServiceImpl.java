package services.impl;

import dao.PlayerDao;
import dao.impl.PlayerDaoImpl;
import exceptions.PlayerAlreadyRegistered;
import models.Player;
import services.PlayerService;

public class PlayerServiceImpl implements PlayerService {

    @Override
    public int createPlayerObject(String playerId, String playerName, int playerAge, String playerGender, int teamId) throws PlayerAlreadyRegistered {
        
        Player player = new Player();

        player.setPlayerId(playerId);
        player.setPlayerName(playerName);
        player.setPlayerAge(playerAge);
        player.setPlayerGender(playerGender);
        player.setTeamId(teamId);

        PlayerDao playerDao = new PlayerDaoImpl();

        int result = 0;

        result = playerDao.createPlayers(player);



        return result;
    }
    
}
