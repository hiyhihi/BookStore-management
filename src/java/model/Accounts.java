/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huyph
 */
public class Accounts {
    private int id;
    private String username;
    private String password;
    private String role;  // thêm trường role cho khớp với SQL

    public Accounts() {
        super();
    }

    public Accounts(String username, String password) {
        super();
        this.username = username;
        this.password = password;
        this.role = "customer"; // mặc định như trong SQL
    }

    public Accounts(String username, String password, String role) {
        super();
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

