package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeamDao;
import dao.impl.TeamDaoImpl;
import models.Team;

public class ViewPlayers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewplayers.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String teamName = req.getParameter("t_name");

        TeamDao teamDao = new TeamDaoImpl();

        Team team = teamDao.getThatTeam(teamName);

        if(team != null) {
            HttpSession session = req.getSession();
            session.setAttribute("team", team);
            resp.sendRedirect("getdetails");
        }
        else {
            resp.sendRedirect("viewplayers?NoSuchTeam=There is no such team!");
        }


    }
    
}
