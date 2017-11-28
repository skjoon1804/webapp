package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Genre {
    public int id;
    public String name;

    public Genre(){
    };

    public Genre(int g_id, String g_name){
        id = g_id;
        name = g_name;
    }


    private static String url = "jdbc:mysql:///moviedb";
    private static String usr = "root";
    private static String paswd = "1111";


    public void getGenreList() throws Exception {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Connection dbcon = DriverManager.getConnection(url, usr, paswd);

        String query = "SELECT * FROM genres;";

        ResultSet rset = dbcon.createStatement().executeQuery(query);

        while (rset.next()) {
            System.out.println(rset.getString(1));
        }
    }


    }
