package dao.categoryDAO;

import model.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> selectAllCatalog();
    boolean editCategory(Category category);
    Category getById(int id);
    boolean deleteCategory(int id);
    void createCategory(Category category );
}
