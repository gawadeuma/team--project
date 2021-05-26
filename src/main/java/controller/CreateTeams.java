package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.TeamRegisteredAlready;
import services.TeamService;
import services.impl.TeamServiceImpl;

public class CreateTeams extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createteams.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String teamName = req.getParameter("t_name");

        TeamService teamService = new TeamServiceImpl();

        int result = 0;

        resp.setContentType("application/json");

        PrintWriter out = resp.getWriter();

        final String data = "Team is successfully Registered!";

        try {
            result = teamService.createTeamObject(teamName);
            if (result != 0) {
                // resp.sendRedirect("createteams?teamsRegistered=Team is successfully
                // Registered!");
                out.write(data);
            }
        } catch (TeamRegisteredAlready e) {
            // resp.sendRedirect("createteams?teamsNotRegistered=" + e.getMessage());
            out.write(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }
}
