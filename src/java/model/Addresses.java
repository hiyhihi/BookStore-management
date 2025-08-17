/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author huyph
 */
public class Addresses {
    private int id;
    private String street;
    private String city;
    private String country;
    private String postalCode;
    private Orders order;   // 1-1 với Order

    public Addresses() {
        super();
    }

    public Addresses(String street, String city, String country, String postalCode, Orders order) {
        super();
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.order = order;
    }

    // getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public Orders getOrder() { return order; }
    public void setOrder(Orders order) { this.order = order; }
}

