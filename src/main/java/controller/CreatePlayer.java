package controller;

import javax.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import dao.TeamDao;
import dao.impl.TeamDaoImpl;
import models.Team;
import services.PlayerService;
import services.impl.PlayerServiceImpl;

public class CreatePlayer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TeamDao teamDao = new TeamDaoImpl();

        List<Team> teams = teamDao.getTeamsList();

        req.setAttribute("teams", teams);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createplayers.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String playerId = req.getParameter("p_id");
        String playerName = req.getParameter("p_name");
        int playerAge = Integer.parseInt(req.getParameter("p_age"));
        String playerGender = req.getParameter("gender");
        int teamNameChoosed = Integer.parseInt(req.getParameter("teams"));

        PlayerService playerService = new PlayerServiceImpl();

        int result = 0;

        try {
            result = playerService.createPlayerObject(playerId, playerName, playerAge, playerGender, teamNameChoosed);

            if (result != 0) {
                resp.sendRedirect("createplayers?playerRegistered=Player is successfully Registered!");
            }
        } catch (Exception e) {
            resp.sendRedirect("createplayers?playerNotRegistered=" + e.getMessage());
        }
    }

}
