<%@ include file="index.jsp"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Create Teams</title>
    <link rel="stylesheet" href="css/home.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  </head>
  <body>
    <div class="container py-3">
      <%@ include file="notheader.jsp"%>
      <main class="container">
        <div class="bg-light p-5 rounded">
          <h1>Create Team</h1>
            <!-- <% if(request.getParameter("teamsRegistered") != null) { %>
            <div class="alert alert-success" role="alert">
              <%= request.getParameter("teamsRegistered") %>
            </div>
            <% } %>
            <% if(request.getParameter("teamsNotRegistered") != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= request.getParameter("teamsNotRegistered") %>
              </div>
            <% } %> -->
            <div  id="teamsRegistered"></div>
            <div class="alert alert-danger" role="alert"  id="error"></div>
          <p class="lead"><form method="POST">
            <div class="mb-3">
              <label for="t_id" class="form-label">Team Name</label>
              <input type="text" class="form-control" placeholder="enter the team name" id="t_id" name="t_name" >
            </div>
            <button type="button" class="btn btn-success" onclick="createTeam()">Create</button>
          </form></p>
        </div>
      </main>
      <%@ include file="footer.jsp"%>
    </div>
    <script>
      function createTeam() {
        $.ajax(
            {
                url: "createteams",
                type: "POST",
                dataType: "application/json",
                data: {t_name:$("#t_id").val()},
                function(data)
                {
                   $("#teamsRegistered").html(data);
                },
                error: function(result)
                {
                  $("#error").html(result).show()
                } 
            });
      }
    </script>
  </body>
</html>
