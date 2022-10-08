package dao.categoryDAO;

import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static connectionDB.ConnectionDB.getConnection;

public class CategoryDAO implements ICategoryDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List<Category> selectAllCatalogByIdUser(int user_id) {
        List<Category> categoryList = new ArrayList<>();
        try {
            String query = "select * from category where user_id = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,user_id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("name");
                String note = resultSet.getString("note");
                int idUser = resultSet.getInt("user_id");
                categoryList.add(new Category(idCategory, name, note, idUser));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    public List<Category> selectAllCatalog() {
        List<Category> categories = new ArrayList<>();
        try {
            String query = "select * from category where user_id=?";
            String query1 = "select * from category where idCategory = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("idCategory");
                String name = resultSet.getString("name");
                String note = resultSet.getString("note");
                int user_id = resultSet.getInt("user_id");
                categories.add(new Category(idCategory, name, note, user_id));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
    @Override
    public boolean editCategory(Category category) {
        boolean rowEdit;
        try {
            String query = "update category set name = ?,note = ? where idCategory = ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setString(2, category.getNote());
            preparedStatement.setInt(3,category.getIdCategory());
            rowEdit = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return rowEdit;
    }

    @Override
    public Category getById(int idCategory) {
        String query = "select idCategory,name,note,user_id from category where idCategory = ? ";
        Category category = null;
        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,idCategory);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String note = resultSet.getString("note");
//                int user_id = resultSet.getInt("user_id");
                category = new Category(idCategory,name,note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category getUserId(int user_id) {
        String query = "select idCategory,name,note,user_id from category where user_id ? ";
        Category userId = null;
        try{
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,user_id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idCategory = resultSet.getInt("idcategory");
                String name = resultSet.getString("name");
                String note = resultSet.getString("note");
//                int user_id = resultSet.getInt("user_id");
                userId = new Category(idCategory,name,note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    @Override
    public boolean deleteCategory(int id) {
        boolean rowCategory = false;
        try{
            String query = "delete from category where idCategory= ?";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            rowCategory = preparedStatement.executeUpdate() >0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCategory;
    }

    @Override
    public void createCategory(Category category) {
        try {
            String query = "insert into category (name,note,user_id) values (?,?,?);";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,category.getName());
            preparedStatement.setString(2,category.getNote());
            preparedStatement.setInt(3,category.getUser_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
