package dao.detailmoneywalletuser;

import model.DetailMoneyWalletUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static connectionDB.ConnectionDB.getConnection;

public class DetailMoneyWalletUserDAO implements IDetailMoneyWalletUserDAO {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public List<DetailMoneyWalletUser> selectDetailMoneyWallet() {
        List<DetailMoneyWalletUser> listDetailWalletUser = new ArrayList<>();
        try{
            String query = "select * from detailmoney_wallet_users2";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idUser = resultSet.getInt("idUser");
                int idWallet = resultSet.getInt("idWallet");
                String icon = resultSet.getString("icon");
                String name = resultSet.getString("name");
                double finalMoney = resultSet.getDouble("finalMoney");
                double sumMoney = resultSet.getDouble("sumMoney");
                listDetailWalletUser.add(new DetailMoneyWalletUser(idUser,idWallet,icon,name,finalMoney,sumMoney));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listDetailWalletUser;
    }
}
