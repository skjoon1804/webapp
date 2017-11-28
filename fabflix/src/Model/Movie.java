package Model;


import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

public class Movie {
    public String id;
    public String title;
    public String year;
    public String director;
    public String banner_url;
    public String trailer_url;

    public List<Actor> lstar;
    public List<Genre> lgenres;

    public Movie(String i, String t, String y, String d, String b, String tr){
        id = i;
        title = t;
        year = y;
        director = d;
        banner_url = b;
        trailer_url = tr;
        lgenres = getGenre(i);
        lstar = getStars(i);
    }

    private static String url = "jdbc:mysql:///moviedb";
    private static String usr = "root";
    private static String paswd = "1111";

    private static Connection dbcon = null;




    public static void Startconnection(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            dbcon = DriverManager.getConnection(url, usr, paswd);
        }catch(Exception ex){

        }

    }

    public static List<Genre> getGenre(String movie_id){

        List<Genre> genre_list = new ArrayList<>();

        String query = "SELECT g.*\n" +
                "FROM genres AS g, genres_in_movies as gim, movies AS mv\n" +
                "WHERE mv.id= " + movie_id + " AND mv.id = gim.movie_id AND gim.genre_id = g.id;";


        try{
            PreparedStatement pst = dbcon.prepareStatement(query);
            ResultSet gResult = pst.executeQuery();

            while(gResult.next()){
                Genre gg = new Genre(gResult.getInt("id"), gResult.getString("name"));
                genre_list.add(gg);
            }


            gResult.close();
            pst.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return genre_list;
    }

    public static List<Actor> getStars(String movie_id){
        List<Actor> star_list = new ArrayList<>();

        String query = "SELECT s.*\n" +
                "FROM stars AS s, stars_in_movies AS sim, movies AS mv\n" +
                "WHERE mv.id="+ movie_id + " AND mv.id = sim.movie_id AND sim.star_id = s.id;";
        try{

            PreparedStatement pst = dbcon.prepareStatement(query);

            ResultSet rset  = pst.executeQuery();

            while(rset.next()){
                Actor aa = new Actor(rset.getInt("id"), rset.getString("first_name"), rset.getString("last_name"), rset.getString("dob"), rset.getString("photo_url"));
                star_list.add(aa);
            }

            rset.close();
            pst.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return star_list;
    }

    public static List<Movie> createMovieList(String query) {
        Startconnection();

        List<Movie> mvlist = new LinkedList<>();

        try{
            PreparedStatement pst = dbcon.prepareStatement(query);

            ResultSet rset = pst.executeQuery();

            while(rset.next()){
                Movie mv = new Movie(rset.getString("id"), rset.getString("title"), rset.getString("year"),rset.getString("director"), rset.getString("banner_url"), rset.getString("trailer_url"));
                mvlist.add(mv);
            }

            rset.close();
            pst.close();
            dbcon.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return mvlist;
    }


}



