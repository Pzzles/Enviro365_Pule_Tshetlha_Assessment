//package com.enviro.assessment.grad001.puletshetlha.puleAssessment.dao;
//
//import Util.DBConnection;
//import com.enviro.assessment.grad001.puletshetlha.puleAssessment.model.AccountProfile;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author PULE
// */
//public class AccountProfileDAO implements DAO {
//
//    private Connection connection;
//
//    public AccountProfileDAO(String url, String username, String password) throws SQLException {
//        connection = DBConnection.getConnection();
//
//    }
//
//    private void createTable() throws SQLException {
//        Statement statement = connection.createStatement();
//        statement.execute("CREATE TABLE IF NOT EXISTS AccountProfilea ("
//                + "id INT PRIMARY KEY AUTO_INCREMENT,"
//                + "name VARCHAR(255) NOT NULL,"
//                + "surname VARCHAR(255) NOT NULL,"
//                + "httpImageLink VARCHAR(255) NOT NULL"
//                + ")");
//    }
//
//    @Override
//    public void addAccountProfile(String name, String surname, String httpImageLink) {
//        try {
//            createTable();
//            PreparedStatement ps = connection.prepareStatement("INSERT INTO AccountProfilea (name, surname, httpImageLink) VALUES (?, ?, ?)");
//            ps.setString(1, name);
//            ps.setString(2, surname);
//            ps.setString(3, httpImageLink);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @Override
//    public AccountProfile getAccountProfileById(int id) {
//        try {
//            //   createTable();
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM AccountProfilea WHERE id = ?");
//            statement.setInt(1, id);
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()) {
//                String name = resultSet.getString("name");
//                String surname = resultSet.getString("surname");
//                String httpImageLink = resultSet.getString("httpImageLink");
//                return new AccountProfile(id, name, surname, httpImageLink);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountProfileDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//
//    @Override
//    public List<AccountProfile> getAccountProfiles() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void close() throws SQLException {
//        connection.close();
//    }
//}
