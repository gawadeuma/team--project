<%@ include file="index.jsp"%>
<%@ page import="models.Team" %>
<%@ page import="models.Player" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>View Players</title>
    <link rel="stylesheet" href="css/home.css" />
  </head>
  <body>
    <div class="container py-3">
      <%@ include file="headerforviewplayers.jsp"%>
      <main class="container">
        <div class="bg-light p-5 rounded">
        <% Team team = (Team) session.getAttribute("team"); %>
        <% List<Player> players = team.getPlayers(); %>
        <h1><%= team.getTeamName() %></h1>
          <table class="table table-striped table-hover">
            <caption>Players in team <%= team.getTeamName() %></caption>
            <thead>
              <tr>
                <th scope="col">Player Id</th>
                <th scope="col">Player Name</th>
                <th scope="col">Player Age</th>
                <th scope="col">Player Gender</th>
              </tr>
            </thead>
            <tbody>
            <% for(Player p : players) { %>
              <tr> 
                <td><%= p.getPlayerId() %></td>
                <td><%= p.getPlayerName() %></td>
                <td><%= p.getPlayerAge() %></td>
                <td><%= p.getPlayerGender() %></td>
              </tr>
            <% } %>
            </tbody>
          </table>    
        </div>
      </main>
      <%@ include file="footer.jsp"%>
    </div>
  </body>
</html>
