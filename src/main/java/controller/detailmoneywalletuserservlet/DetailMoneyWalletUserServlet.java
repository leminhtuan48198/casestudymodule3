package controller.detailmoneywalletuserservlet;

import dao.detailmoneywalletuser.DetailMoneyWalletUserDAO;
import model.DetailMoneyWalletUser;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "detailMoneyWalletUser", urlPatterns = "/detailMWU")

public class DetailMoneyWalletUserServlet extends HttpServlet {
    private DetailMoneyWalletUserDAO detailMoneyWalletUserDAO;

    public void init() {
        detailMoneyWalletUserDAO = new DetailMoneyWalletUserDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {

                default:
                    displayDetailMWU(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void displayDetailMWU(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<DetailMoneyWalletUser> detailMWUList = detailMoneyWalletUserDAO.selectDetailMoneyWallet();
            request.setAttribute("detailMWUList", detailMWUList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewdetailMWU/listDetailMWU.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
