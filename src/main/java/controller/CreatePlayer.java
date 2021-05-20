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

public class CreatePlayer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TeamDao teamDao = new TeamDaoImpl();

        List<Team> teams = teamDao.getTeamsList();

        req.setAttribute("teams", teams);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createplayers.jsp");
        requestDispatcher.forward(req, resp);
    }

}
