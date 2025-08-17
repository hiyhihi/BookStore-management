/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Books;
import model.Orders;
import model.OrderList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author huyph
 */
public class OrderDAO extends DAO{
    public boolean createOrder(Orders order) {
    String sql = "INSERT INTO Orders(orderDate, totalAmount, status, note, customer_id) VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, order.getOrderDate().toString());
        ps.setDouble(2, order.getTotalAmount());
        ps.setString(3, order.getStatus());
        ps.setString(4, order.getNote());
        ps.setInt(5, order.getCustomer().getId());

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch(Exception e) {
        e.printStackTrace();
    }
        return false;
    }
}
