package services;

import exceptions.TeamRegisteredAlready;

public interface TeamService {
    int createTeamObject(String teamName) throws TeamRegisteredAlready;
}
