import Model.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SingleMovie extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String id = request.getParameter("f_id");


        String query = "SELECT DISTINCT mv.* \n" +
                "FROM movies as mv, stars_in_movies AS sim, stars AS st\n" +
                "WHERE mv.id ="+ id + " AND mv.id = sim.movie_id AND sim.star_id = st.id;";
        System.out.println(query);

        List<Movie> mvlist = Movie.createMovieList(query);

        request.getSession().setAttribute("singleMovie", mvlist);

        RequestDispatcher rd = request.getRequestDispatcher("singlemovie");
        rd.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
