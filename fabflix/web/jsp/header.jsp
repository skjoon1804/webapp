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


<body>

    <%
        String login = (String) request.getSession().getAttribute("login");

        if(login != null){
            %>
    <%
        }else{
            response.sendRedirect("index.jsp");

        }


    %>
    <div id="header">
        <h2 title="Login"> FabFlix </h2>
        
        <nav id="navigation">
            <ul class="clearfix">
                <li class="focus"> <a href="main"> Home </a></li>
                <li> <a href="search"> Search </a></li>
                <li> <a href="browse"> Browse </a></li>
                <li><a href="#"> ShoppingCart </a></li>
                <li><a href="logout"> Logout </a></li>
                <li>
                    <form id="serach_movie" action="searching" method="get">
                        <input id="f_title" name="f_title" type="text" placeholder="search movie title">
                        <script></script>
                        <button>submit</button>
                    </form>
                </li>
            </ul>
        </nav>    
    </div>
