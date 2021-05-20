package dao;

import exceptions.TeamRegisteredAlready;
import models.Team;

public interface TeamDao {
    int createTeams(Team team) throws TeamRegisteredAlready;
}
