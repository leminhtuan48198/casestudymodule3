package dao;

import connectionDB.ConnectionDB;
import model.DetailMoney;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailMoneyDAO implements IDetailMoneyDAO{
    public  DetailMoneyDAO(){}
    protected Connection getConnection(){
        Connection connection=ConnectionDB.getConnection();
        return connection;
    }
    @Override
    public void insertDetailMoneyIn(DetailMoney detailMoney) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into detailMoney(id_wallet,money,note,date) values (?,?,?,?)");
        preparedStatement.setInt(1,detailMoney.getId_wallet());
        preparedStatement.setDouble(2,detailMoney.getMoney());
//        preparedStatement.setInt(3,detailMoney.getId_category());
        preparedStatement.setString(3,detailMoney.getNote());
        preparedStatement.setDate(4,detailMoney.getDate());
        preparedStatement.executeUpdate();
    }
public void insertDetailMoneyOut(DetailMoney detailMoney) throws SQLException {
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into detailMoney(id_wallet,money,id_category,note,date) values (?,?,?,?,?)");
        preparedStatement.setInt(1,detailMoney.getId_wallet());
        preparedStatement.setDouble(2,detailMoney.getMoney());
        preparedStatement.setInt(3,detailMoney.getId_category());
        preparedStatement.setString(4,detailMoney.getNote());
        preparedStatement.setDate(5,detailMoney.getDate());
        preparedStatement.executeUpdate();
    }

    @Override
    public DetailMoney selectDetailMoney(int id) {
        DetailMoney detailMoney=null;
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select  * from detailMoney where idDetail=?");
            preparedStatement.setInt(1,id);
            ResultSet rs =preparedStatement.executeQuery();
            while(rs.next()){

                int id_wallet=rs.getInt("id_wallet");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                 detailMoney=new DetailMoney(id,id_wallet,money,id_category,note,date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailMoney;
    }

    @Override
    public List<DetailMoney> selectAllDetailMoneys() {
        List<DetailMoney> detailMoneyList=new ArrayList<>();
        Connection connection=getConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement("select * from detailMoney");
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                int idDetail=rs.getInt("idDetail");
                int id_wallet=rs.getInt("id_wallet");
                double money=rs.getDouble("money");
                int id_category=rs.getInt("id_category");
                String note =rs.getString("note");
                Date date=rs.getDate("date");
                detailMoneyList.add(new DetailMoney(idDetail,id_wallet,money,id_category,note,date));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailMoneyList;
    }

    @Override
    public boolean deleteDetailMoney(int id) throws SQLException {
        boolean rowDeleted;
        Connection connection=getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("delete  from detailMoney where idDetail=?");
        preparedStatement.setInt(1,id);
        rowDeleted=preparedStatement.executeUpdate()>0;
        return rowDeleted;
    }

    @Override
    public boolean updateDetailMoney(DetailMoney detailMoney) throws SQLException {
        boolean rowUpdated;
        Connection connection=getConnection();
        PreparedStatement preparedStatement =connection.prepareStatement("update detailMoney set " +
                "id_wallet=?,money=?,id_category=?,note=?,date=? where idDetail=?");
        preparedStatement.setInt(1,detailMoney.getId_wallet());
        preparedStatement.setDouble(2,detailMoney.getMoney());
        preparedStatement.setInt(3,detailMoney.getId_category());
        preparedStatement.setString(4,detailMoney.getNote());
        preparedStatement.setDate(5,detailMoney.getDate());
        preparedStatement.setInt(6,detailMoney.getIdDetail());
        rowUpdated=preparedStatement.executeUpdate()>0;
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
