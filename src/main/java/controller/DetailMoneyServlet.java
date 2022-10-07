package controller;


import dao.DetailMoneyDAO;
import model.DetailMoney;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="DetailMoneyServlet", urlPatterns = "/detailMoneys")
public class DetailMoneyServlet extends HttpServlet {
    private DetailMoneyDAO detailMoneyDAO;

    public void init() {
        detailMoneyDAO = new DetailMoneyDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertDetailMoney(request, response);
                    break;
                case "edit":
                    updateDetailMoney(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteDetailMoney(request, response);
                    break;
                default:
                    listDetailMoney(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listDetailMoney(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<DetailMoney> listDetailMoney = detailMoneyDAO.selectAllDetailMoneys();
        request.setAttribute("listDetailMoney", listDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DetailMoney existingDetailMoney = detailMoneyDAO.selectDetailMoney(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/edit.jsp");
        request.setAttribute("detailMoney", existingDetailMoney);
        dispatcher.forward(request, response);

    }

    private void insertDetailMoney(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

//        int idDetail =Integer.parseInt(request.getParameter("idDetail"));
        int id_wallet=Integer.parseInt(request.getParameter("id_wallet"));
        double money=Double.parseDouble((request.getParameter("money")));
        int id_category=Integer.parseInt(request.getParameter("id_category"));
        String note =request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(id_wallet,money,id_category,note,date);
        detailMoneyDAO.insertDetailMoney(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateDetailMoney(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int idDetail = Integer.parseInt(request.getParameter("idDetail"));
//        String name = request.getParameter("name");
//        String email = request.getParameter("email");
//        String country = request.getParameter("country");
//        DetailMoney detailMoney = new DetailMoney(id, name, email, country);
        int id_wallet=Integer.parseInt(request.getParameter("id_wallet"));
        double money=Double.parseDouble((request.getParameter("money")));
        int id_category=Integer.parseInt(request.getParameter("id_category"));
        String note =request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(idDetail,id_wallet,money,id_category,note,date);

        detailMoneyDAO.updateDetailMoney(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteDetailMoney(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        detailMoneyDAO.deleteDetailMoney(id);

        List<DetailMoney> listDetailMoney = detailMoneyDAO.selectAllDetailMoneys();
        request.setAttribute("listDetailMoney", listDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/list.jsp");
        dispatcher.forward(request, response);
    }
} 

