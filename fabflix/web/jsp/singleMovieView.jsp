
<!DOCTYPE html>
<html lang="en" class="no-js modern">
<title> Fabflix </title>

<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, javax.sql.*, java.io.IOException"%>
<%@ page import="javax.swing.text.StyledEditorKit" %>
<%@ page import="javax.servlet.http.*" %>
<%@ page import="java.lang.*" %>
<%@ page import="java.util.*" %>
<%@ page import="Model.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<head>

    <link rel="stylesheet" href="css/style.css" />
    <link href="http://fonts.googleapis.com/css?family=Sansita+One" rel="stylesheet" />



    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="js/jquery.bpopup.min.js"></script>
    <script src="js/autocomplete.js"></script>

    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
</head>


<body><%
    List<Movie> mvlist = (List<Movie>) request.getSession().getAttribute("singleMovie");
%>

<div id="reg" style="width: 500px; left: 10%; margin-left: 0px; top: 10px">
    <%
        for(Movie mv : mvlist){

    %>

    <div style="width: 200px; height: 300px; float:left; "> <img src="http://placehold.it/200x300" /> </div>
    <div style="width: 200px; height:300px; float:left;">
        <div id="id" style="padding-top: 20px;">
            ID:<%out.print(mv.id);%>
        </div>

        <div id="title" style="padding-top: 20px;">
            title:<%out.print(mv.title);%>
        </div>

        <div id="year" style="padding-top: 20px;">
            year:<%out.print(mv.year);%>
        </div>

        <div id="director" style="padding-top: 20px;">
            director:<%out.print(mv.director);%>
        </div>

        <div id="genre" style="padding-top: 20px;">
            genre:
            <%
                for(Genre ge : mv.lgenres){
                    out.println(ge.name);
                }
            %>
        </div>

        <div id="trailer" style="padding-top: 20px;">
            trailer: <a href="<%out.print(mv.trailer_url);%>"> direct_url </a>
        </div>

        <div id="actor" style="padding-top: 20px;">
            actors:
            <%
                for(Actor ac : mv.lstar){
                    out.println(ac.name);
            }
            %>
        </div>

    <%
        }
    %>
    </div>
</div>

    </body>
    </html>
