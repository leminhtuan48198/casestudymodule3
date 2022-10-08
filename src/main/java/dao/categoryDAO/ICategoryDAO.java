package dao.categoryDAO;

import model.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> selectAllCatalogByIdUser(int user_id);
    boolean editCategory(Category category);
    Category getById(int idCategory);
    Category getUserId ( int User_id);
    boolean deleteCategory(int id);
    void createCategory(Category category );

}
