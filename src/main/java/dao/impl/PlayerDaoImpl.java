package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.PlayerDao;
import exceptions.PlayerAlreadyRegistered;
import models.Player;
import utilities.DbConnection;
import utilities.impl.DbConnectionImpl;

public class PlayerDaoImpl implements PlayerDao {

    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    @Override
    public int createPlayers(Player player) throws PlayerAlreadyRegistered {
        DbConnection dbConnection = new DbConnectionImpl();

        final String CREATE_PLAYERS = " INSERT INTO players(player_id,player_name,player_age,player_gender,team_id) VALUES(?,?,?,?,?) ";

        int result = 0;

        try {
            connection = dbConnection.getConnection(connection);
            preparedStatement = connection.prepareStatement(CREATE_PLAYERS);
            preparedStatement.setString(1, player.getPlayerId());
            preparedStatement.setString(2, player.getPlayerName());
            preparedStatement.setInt(3, player.getPlayerAge());
            preparedStatement.setString(4, player.getPlayerGender());
            preparedStatement.setInt(5, player.getTeamId());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new PlayerAlreadyRegistered("Player is already Registered!");
        }
        return result;
    }
    
}
