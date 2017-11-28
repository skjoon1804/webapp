import java.io.*;
import javax.servlet.*;
import java.sql.*;
import javax.servlet.http.*;

public class Login extends HttpServlet {


    private static String url = "jdbc:mysql:///moviedb";
    private static String usr = "root";
    private static String paswd = "1111";

    private static boolean ValidateUser(String email, String password){
        boolean login = false;
        String query = "SELECT email FROM customers WHERE email =? AND password=?;";

        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            Connection dbcon = DriverManager.getConnection(url, usr, paswd);
            PreparedStatement pst = dbcon.prepareStatement(query);
            pst.setString(1,email);
            pst.setString(2,password);

            ResultSet rset = pst.executeQuery();

            if(rset.next()){
                login = true;
            }

            pst.close();
            dbcon.close();

        }catch (Exception ex){
            ex.notify();
        }

        return login;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession hs = request.getSession();

        PrintWriter out = response.getWriter();

        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
       // System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);

        // Verify CAPTCHA.
//        boolean valid = VerifyUtils.verify(gRecaptchaResponse);
//
//        if (!valid) {
//            //errorString = "Captcha invalid!";
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('ReCapacha Verification');");
//            out.println("</script>");
//
//            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//            rd.forward(request,response);
//        }
//
        String email =  request.getParameter("u_email");
        String password = request.getParameter("u_password");


        if(ValidateUser(email,password)){
            out.println("<script type=\"text/javascript\">");
            out.println("alert('LOGIN SUCCESS');");
            out.println("</script>");

            request.getSession().setAttribute("login",email);
            RequestDispatcher rd = request.getRequestDispatcher("main");
            rd.forward(request,response);

        }else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('LOGIN FAIL');");
            out.println("</script>");

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
    }

}