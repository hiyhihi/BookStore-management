/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Books;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
/**
 *
 * @author huyph
 */
public class BookDAO extends DAO{
    public boolean createBook(Books book) {
    String sql = "INSERT INTO Books(title, author, publisher, price, stockQuantity) VALUES (?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, book.getTitle());
        ps.setString(2, book.getAuthor());
        ps.setString(3, book.getPublisher());
        ps.setDouble(4, book.getPrice());
        ps.setInt(5, book.getStockQuantity());

        int rows = ps.executeUpdate();
        return rows > 0;
    } catch(Exception e) {
        e.printStackTrace();
    }
        return false;
    }
    
    public boolean updateBook(Books book){
        String sql = "UPDATE Books SET title=?, author=?, publisher=?, price=?, stockQuantity=? WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setDouble(4, book.getPrice());
            ps.setInt(5, book.getStockQuantity());
            ps.setInt(6, book.getId());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteBook(Books book){
        String sql = "DELETE FROM Books WHERE id=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, book.getId());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Books> getAllBook(){
        ArrayList<Books> list = new ArrayList<>();
        String sql = "SELECT * FROM Books";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getDouble("price"));
                book.setStockQuantity(rs.getInt("stockQuantity"));
                list.add(book);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Books> searchBook(String name){
        ArrayList<Books> result = new ArrayList<>();
        String sql = "SELECT * FROM Books WHERE title LIKE ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setPrice(rs.getDouble("price"));
                book.setStockQuantity(rs.getInt("stockQuantity"));
                result.add(book);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
