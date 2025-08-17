/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huyph
 */
import java.util.ArrayList;
import java.util.List;

public class Customers {
    private int id;
    private String fullName;
    private String phone;
    private String email;
    private Accounts account;          
    private List<Orders> orders;          

    public Customers() {
        super();
        this.orders = new ArrayList<>();
    }

    public Customers(String fullName, String phone, String email, Accounts account) {
        super();
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.account = account;
        this.orders = new ArrayList<>();
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Accounts getAccount() { return account; }
    public void setAccount(Accounts account) { this.account = account; }

    public List<Orders> getOrders() { return orders; }
    public void setOrders(List<Orders> orders) { this.orders = orders; }
}


