package services.impl;

import dao.TeamDao;
import dao.impl.TeamDaoImpl;
import exceptions.TeamRegisteredAlready;
import models.Team;
import services.TeamService;

public class TeamServiceImpl implements TeamService {

    @Override
    public int createTeamObject(String teamName) throws TeamRegisteredAlready {
        
        Team team = new Team();

        int result = 0;

        team.setTeamName(teamName);

        TeamDao teamDao = new TeamDaoImpl();

        result = teamDao.createTeams(team);

        return result;

    }
    
}
