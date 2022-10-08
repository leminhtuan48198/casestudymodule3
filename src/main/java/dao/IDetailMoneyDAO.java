package dao;

import model.DetailMoney;

import java.sql.SQLException;
import java.util.List;

public interface IDetailMoneyDAO {
    void insertDetailMoneyIn(DetailMoney detailMoney) throws SQLException;

    public void insertDetailMoneyOut(DetailMoney detailMoney) throws SQLException;

    public DetailMoney selectDetailMoney(int id);

    public List<DetailMoney> selectAllDetailMoneys();

    public boolean deleteDetailMoney(int id) throws SQLException;

    public boolean updateDetailMoney(DetailMoney detailMoney) throws SQLException;
}