/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huyph
 */
public class OrderList {
    private int id;
    private Orders order;  
    private Books book;    
    private int quantity;
    private double price;

    public OrderList() {
        super();
    }

    public OrderList(Orders order, Books book, int quantity, double price) {
        super();
        this.order = order;
        this.book = book;
        this.quantity = quantity;
        this.price = price;
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Orders getOrder() { return order; }
    public void setOrder(Orders order) { this.order = order; }

    public Books getBook() { return book; }
    public void setBook(Books book) { this.book = book; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

