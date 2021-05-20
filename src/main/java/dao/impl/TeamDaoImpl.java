package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.TeamDao;
import exceptions.TeamRegisteredAlready;
import models.Team;
import utilities.DbConnection;
import utilities.impl.DbConnectionImpl;

public class TeamDaoImpl implements TeamDao {

    Connection connection = null;

    PreparedStatement preparedStatement = null;

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
        }
        
        return result;
    }

}
