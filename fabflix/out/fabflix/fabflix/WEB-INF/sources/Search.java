import Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;


public class Search extends HttpServlet {


    private static String url = "jdbc:mysql:///moviedb";
    private static String usr = "root";
    private static String paswd = "1111";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String query = "SELECT DISTINCT mv.*\n" +
                "FROM movies AS mv\n" +
                "JOIN\n" +
                "(\n" +
                "\tSELECT sim.movie_id AS m_id\n" +
                "\tFROM stars_in_movies AS sim, stars AS st\n" +
                "    WHERE sim.star_id= st.id";

        String title = request.getParameter("f_title");
        String year = request.getParameter("f_year");
        String director = request.getParameter("f_director");
        String first_name = request.getParameter("f_first_name");
        String last_name = request.getParameter("f_last_name");

        if(!"".equals(first_name) && !"".equals(last_name) ){
            query += " AND st.first_name LIKE \"%" + first_name +  "%\" AND st.last_name LIKE \"%" + last_name + "%\"\n";
        }
        else if(!"".equals(first_name) && "".equals(last_name)){
            query += " AND st.first_name LIKE \"%" + first_name +  "%\"\n";
        }
        else if("".equals(first_name) && !"".equals(last_name)){
            query += " AND st.last_name LIKE \"%" + last_name + "%\"\n";
        }


        query += ")actor\n" +
                "\tON mv.id = actor.m_id";

        if(!"".equals(title)){
            query += " AND mv.title LIKE \"%" + title + "%\" ";
        }
        if(!"".equals(year)){
            query += " AND mv.year= " + year;
        }
        if(!"".equals(director)){
            query += " AND mv.director LIKE \"%" + director +  "%\"";
        }

        if(first_name == null && last_name == null && director == null && year == null && title != null){
            query = "SELECT DISTINCT * FROM movies WHERE title LIKE \"%" + title + "%\" ";
        }

        query += "\n" +
                "LIMIT 10 OFFSET 0;";

        List<Movie> mvlist = Movie.createMovieList(query);

        request.getSession().setAttribute("movielist", mvlist);

        RequestDispatcher rd = request.getRequestDispatcher("MovieView");
        rd.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}