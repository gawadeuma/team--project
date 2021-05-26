package dao;

import java.util.List;

import exceptions.TeamRegisteredAlready;
import models.Team;

public interface TeamDao {
    int createTeams(Team team) throws TeamRegisteredAlready;

    List<Team> getTeamsList();

    Team getThatTeam(String teamName);
}
