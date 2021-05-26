package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import dao.PlayerDao;
import dao.TeamDao;
import exceptions.TeamRegisteredAlready;
import models.Team;
import utilities.DbConnection;
import utilities.impl.DbConnectionImpl;

public class TeamDaoImpl implements TeamDao {

    Connection connection = null;

    PreparedStatement preparedStatement = null;

    ResultSet resultSet = null;

    @Override
    public int createTeams(Team team) throws TeamRegisteredAlready {
        DbConnection dbConnection = new DbConnectionImpl();

        final String CREATE_USER = "INSERT INTO teams(team_name) VALUES(?)";

        int result = 0;

        try {
            connection = dbConnection.getConnection(connection);
            preparedStatement = connection.prepareStatement(CREATE_USER);
            preparedStatement.setString(1, team.getTeamName());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new TeamRegisteredAlready("Team is already registered!");
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
    public List<Team> getTeamsList() {

        DbConnection dbConnection = new DbConnectionImpl();

        final String GET_TEAM_LIST = "SELECT * FROM teams";

        List<Team> teams = new ArrayList<>();

        try {
            connection = dbConnection.getConnection(connection);
            preparedStatement = connection.prepareStatement(GET_TEAM_LIST);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Team team = new Team();

                team.setTeamId(resultSet.getInt("team_id"));
                team.setTeamName(resultSet.getString("team_name"));

                teams.add(team);
            }
        } catch (Exception e) {
            // TODO: handle exception
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

        return teams;
    }

    @Override
    public Team getThatTeam(String teamName) {

        DbConnection dbConnection = new DbConnectionImpl();

        final String GET_THAT_TEAM = "SELECT team_id, team_name FROM teams where team_name=?";

        PlayerDao playerDao = new PlayerDaoImpl();

        Team team = null;

        try {
            connection = dbConnection.getConnection(connection);
            preparedStatement = connection.prepareStatement(GET_THAT_TEAM);
            preparedStatement.setString(1, teamName);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                team = new Team();

                team.setTeamId(resultSet.getInt("team_id"));
                team.setTeamName(resultSet.getString("team_name"));
                team.setPlayers(playerDao.getPLayers(team.getTeamId()));
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

        return team;
        
    }

}
