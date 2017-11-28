import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.*;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.sql.DataSource;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AutoComplete extends HttpServlet {


    private static String url = "jdbc:mysql:///moviedb";
    private static String usr = "root";
    private static String paswd = "1111";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        String name = request.getParameter("term");
        String names[] = name.split(" ");

        try{

            String currentDirectory;
            File file = new File(".");
            currentDirectory = file.getAbsolutePath();
            System.out.println("Current working directory : "+currentDirectory);
            PrintWriter pp = new PrintWriter(new FileWriter("logs/test.txt",true));




            long start_time = System.nanoTime();
            Context initCtx;
            initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");
            Connection dbcon = ds.getConnection();

//            Class.forName("com.mysql.jdbc.Driver");
//            Connection dbcon = DriverManager.getConnection(url, usr, paswd);

            long end_time = System.nanoTime();
            long elasped_time = end_time - start_time;
            pp.print("TJ:" + elasped_time + " ");

            String query = "SELECT title FROM movies WHERE title LIKE \"%" + name + "%\" \n LIMIT 50";


            PreparedStatement pst = dbcon.prepareStatement(query);

            start_time = System.nanoTime();

            ResultSet rset = pst.executeQuery();

            //with out prepared statement !!
            //ResultSet rset = dbcon.createStatement().executeQuery(query);

            end_time = System.nanoTime();

            elasped_time = end_time - start_time;
            pp.println("TS:" + elasped_time);



            pp.flush();
            pp.close();

            List<String> list = new ArrayList<>();

           while(rset.next()){
                list.add(rset.getString("title"));
           }


            String solution = new Gson().toJson(list);

            response.getWriter().println(solution);
            rset.close();
            //pst.close();
            dbcon.close();

//            envCtx.close();
//            envCtx = null;

        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}