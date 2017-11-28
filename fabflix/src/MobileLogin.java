import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnoh on 5/15/16.
 */
public class MobileLogin extends HttpServlet {

    private static String url = "jdbc:mysql:///moviedb";
    private static String usr = "root";
    private static String paswd = "1111";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("application/json");
        String name = request.getParameter("email");
        String password = request.getParameter("password");
        String query = "SELECT email FROM customers WHERE email =? AND password=?;";


        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection dbcon = DriverManager.getConnection(url, usr, paswd);

            PreparedStatement pst = dbcon.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, password);

            ResultSet rset = pst.executeQuery();
            List<String> list = new ArrayList<>();

            if(rset.next()){
                rset.previous();
                list.add("true");
            }
            else{
                list.add("false");
            }

            String solution = new Gson().toJson(list);
            response.getWriter().println(solution);

            rset.close();
            pst.close();
            dbcon.close();

        }catch(Exception ex){
            response.getWriter().println("Error!!!!!!");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
