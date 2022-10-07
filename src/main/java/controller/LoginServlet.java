package controller;

import connectionDB.ConnectionDB;
import dao.UserDAOImpl;
import model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            UserDAOImpl dao=new UserDAOImpl(ConnectionDB.getConnection());
            HttpSession session=req.getSession();
            String userName =req.getParameter("userName");
            String password = req.getParameter("password");
            Users us=dao.checkLogin(userName,password);
            if (us!=null){
                session.setAttribute("userobj",us);
                resp.sendRedirect("home.jsp");
            }else {
                session.setAttribute("failedMsg","userName &Password Invalid");
                resp.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
