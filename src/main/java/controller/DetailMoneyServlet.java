package controller;


import dao.DetailMoneyDAO;
import dao.categoryDAO.CategoryDAO;
import model.Category;
import model.DetailMoney;
import model.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="DetailMoneyServlet", urlPatterns = "/detailMoneys")
public class DetailMoneyServlet extends HttpServlet {
    private DetailMoneyDAO detailMoneyDAO;
    public CategoryDAO categoryDAO =new CategoryDAO();

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
                case "createOut":
                    insertDetailMoneyOut(request, response);
                    break;
                case "createIn":
                    insertDetailMoneyIn(request, response);
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
                case "createIn":
                    showNewFormIn(request, response);
                    break;
                case "createOut":
                    showNewFormOut(request, response);
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

    private void showNewFormIn(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUser=0;


        List<Category> categoryList=new ArrayList<>();
        categoryList=categoryDAO.selectCategoryByIdUser(idUser);
        request.setAttribute("categoryList",categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyIn.jsp");

        dispatcher.forward(request, response);
    }
    private void showNewFormOut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession httpSession=request.getSession();

        int user_id= (int) httpSession.getAttribute("idUser");
        List<Category> categoryList=new ArrayList<>();
        CategoryDAO categoryDAO=new CategoryDAO();
        categoryList=categoryDAO.selectAllCatalogByIdUser(user_id);
        request.setAttribute("categoryList",categoryList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyOut.jsp");
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

    private void insertDetailMoneyIn(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

//        int idDetail =Integer.parseInt(request.getParameter("idDetail"));
        int id_wallet=Integer.parseInt(request.getParameter("id_wallet"));
        double money=Double.parseDouble((request.getParameter("money")));
//        int id_category=Integer.parseInt(request.getParameter("id_category"));
        String note =request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(id_wallet,money,note,date);
        detailMoneyDAO.insertDetailMoneyIn(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyIn.jsp");
        dispatcher.forward(request, response);
    }
    private void insertDetailMoneyOut(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

//        int idDetail =Integer.parseInt(request.getParameter("idDetail"));
        int id_wallet=Integer.parseInt(request.getParameter("id_wallet"));
        double money=-Double.parseDouble((request.getParameter("money")));
        int id_category=Integer.parseInt(request.getParameter("id_category"));
        String note =request.getParameter("note");
        Date date = Date.valueOf(request.getParameter("date"));
        DetailMoney newDetailMoney = new DetailMoney(id_wallet,money,id_category,note,date);
        detailMoneyDAO.insertDetailMoneyOut(newDetailMoney);
        RequestDispatcher dispatcher = request.getRequestDispatcher("detailMoney/createMoneyOut.jsp");
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

