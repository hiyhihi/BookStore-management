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
import java.util.Date;
import java.util.List;

public class Orders {
    private int id;
    private Date orderDate;
    private double totalAmount;
    private String status;
    private String note;
    private Customers customer;          
    private Addresses address;              
    private List<OrderList> orderLists;    

    public Orders() {
        super();
        this.orderLists = new ArrayList<>();
    }

    public Orders(Date orderDate, double totalAmount, String status, String note, Customers customer) {
        super();
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.note = note;
        this.customer = customer;
        this.orderLists = new ArrayList<>();
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public Customers getCustomer() { return customer; }
    public void setCustomer(Customers customer) { this.customer = customer; }

    public Addresses getAddress() { return address; }
    public void setAddress(Addresses address) { this.address = address; }

    public List<OrderList> getOrderLists() { return orderLists; }
    public void setOrderLists(List<OrderList> orderLists) { this.orderLists = orderLists; }
}

