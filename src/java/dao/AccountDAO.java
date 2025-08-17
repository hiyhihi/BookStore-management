/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import model.Accounts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author huyph
 */
public class AccountDAO extends DAO{
    public AccountDAO() {
	super();
    }
    
    public boolean checkLogin(Accounts account) {
		boolean result = false;
		String sql = "SELECT * FROM accounts WHERE username = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, account.getUsername());
			ps.setString(2, account.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
    }
    
    public int register(Accounts account) {
    String sql = "INSERT INTO Accounts (username, password, role) VALUES (?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, account.getUsername());
        ps.setString(2, account.getPassword());
        ps.setString(3, "customer"); // mặc định là customer
        int rows = ps.executeUpdate();
        if (rows > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1); // account_id vừa tạo
            }
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
        return -1;
    }
}
