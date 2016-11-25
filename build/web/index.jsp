<%-- 
    Document   : index
    Created on : Nov 23, 2016, 9:51:28 PM
    Author     : dell
--%>


<%@page import="com.leapfrog.jspjdbc.dao.ClientDAO"%>
<%@page import="com.leapfrog.jspjdbc.dao.impl.ClientDaoImpl"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.leapfrog.jspjdbc.entity.Project"%>
<%@page import="com.leapfrog.jspjdbc.entity.Client"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My first JSP page</title>
        <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
        <h1>Clients</h1>
        <div class="pull-right">
            <p>
                Add Client
            </p>
        </div>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Contact NO</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
        <%
            ClientDAO clientDAO = new ClientDaoImpl();

           // Client client = new Client(1, "Verisk Technologies", "rowan@verisk.com", "9818965605", false);
            try {

                for(Client c:clientDAO.getAll())
                {
                    %>
                    <tr>
                        <td><%=c.getId() %></td>
                        <td><%=c.getName() %></td>
                        <td><%=c.getEmail() %></td>
                        <td><%=c.getContactNo()%></td>
                        <td><%=c.isStatus() %></td>
                        <td>Edit Delete</td>
                    </tr>
                <%}

            } catch (Exception e) {
                out.println(e.getMessage());
            }

        %>
        </table>
    </div>

    </body>
</html>
