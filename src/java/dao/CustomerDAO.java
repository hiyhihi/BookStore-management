/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Customers;
import model.Accounts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author huyph
 */
public class CustomerDAO extends DAO {
    public boolean addCustomer(Customers customer) {
    String sql = "INSERT INTO Customers(fullName, phone, email, account_id) VALUES (?, ?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, customer.getFullName());
        ps.setString(2, customer.getPhone());
        ps.setString(3, customer.getEmail());
        ps.setInt(4, customer.getAccount().getId());

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch(Exception e) {
        e.printStackTrace();
    }
    return false;
    }
}
