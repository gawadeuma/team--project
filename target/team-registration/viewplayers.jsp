<%@ include file="index.jsp"%>
<%@ page import="models.Team" %>
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
          <h1>View Players</h1>
          <% if(request.getParameter("NoSuchTeam") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getParameter("NoSuchTeam") %>
              </div>
            <% } %>
          <p class="lead">
            <form action="viewplayers" method="POST">
                <div class="mb-3">
                    <label for="t_id" class="form-label">Team Name</label>
                    <input type="text" class="form-control" placeholder="enter the team name" id="t_id" name="t_name" >
                </div>
                <button type="submit" class="btn btn-secondary">View</button>
            </form>
          </p>
        </div>
      </main>
      <%@ include file="footer.jsp"%>
    </div>
  </body>
</html>
