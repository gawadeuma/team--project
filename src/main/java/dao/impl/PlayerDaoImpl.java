package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

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
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        return result;
    }

    @Override
    public List<Player> getPLayers(int teamId) {
        
        DbConnection dbConnection = new DbConnectionImpl();

        List<Player> players = null;

        final String GET_PLAYERS_FOR_PARTICULAR_TEAM_ID = "SELECT player_id, player_name, player_age, player_gender FROM players WHERE team_id=?";

        try {
            connection = dbConnection.getConnection(connection);
            preparedStatement = connection.prepareStatement(GET_PLAYERS_FOR_PARTICULAR_TEAM_ID);
            preparedStatement.setInt(1, teamId);
            resultSet = preparedStatement.executeQuery();

            players = new ArrayList<>();

            while(resultSet.next()) {
                Player player = new Player();

                player.setPlayerId(resultSet.getString("player_id"));
                player.setPlayerName(resultSet.getString("player_name"));
                player.setPlayerAge(resultSet.getInt("player_age"));
                player.setPlayerGender(resultSet.getString("player_gender"));

                players.add(player);
            }

        } catch (Exception e) {
            //TODO: handle exception
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        return players;
    }
    
}
