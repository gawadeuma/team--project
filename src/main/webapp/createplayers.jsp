<%@ include file="index.jsp"%>
<%@ page import="models.Team" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Players</title>
    <link rel="stylesheet" href="css/home.css" />
  </head>
  <body>
    <div class="container py-3">
      <%@ include file="notheader.jsp"%>
      <main class="container">
        <div class="bg-light p-5 rounded">
          <h1>Create Players</h1>
            <% if(request.getParameter("playerRegistered") != null) { %>
            <div class="alert alert-success" role="alert">
              <%= request.getParameter("playerRegistered") %>
            </div>
            <% } %>
            <% if(request.getParameter("playerNotRegistered") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getParameter("playerNotRegistered") %>
              </div>
            <% } %>
          <p class="lead"><form action="createplayers" method="POST">
            <div class="mb-3">
                <label for="p_id" class="form-label">Player ID</label>
                <input type="text" class="form-control" placeholder="enter the player id" id="p_id" name="p_id" >
            </div>
            <div class="mb-3">
              <label for="p_name" class="form-label">Player Name</label>
              <input type="text" class="form-control" placeholder="enter the player name" id="p_name" name="p_name" >
            </div>
            <div class="mb-3">
                <label for="p_age" class="form-label">Player Age</label>
                <input type="text" class="form-control" placeholder="enter the player age" id="p_age" name="p_age" >
            </div>
            <div class="mb-3">
                <label for="p_gender" class="form-label">Gender</label>
                <select class="form-select" id="p_gender" name="gender">
                    <option selected>Choose...</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="others">Others</option>
                </select>
            </div>
            <% List<Team> teams = (List<Team>) request.getAttribute("teams"); %>
            <div class="mb-3">
              <label for="t_list" class="form-label">Choose a Team</label>
                <select class="form-select" id="t_list" name="teams">
                    <option selected>Choose...</option>
                    <% for(Team t : teams) { %>
                      <option value="<%= t.getTeamId() %>"><%= t.getTeamName() %></option>
                    <% } %>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
          </form></p>
        </div>
      </main>
      <%@ include file="footer.jsp"%>
    </div>
  </body>
</html>
