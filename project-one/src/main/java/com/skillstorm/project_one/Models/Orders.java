package com.skillstorm.project_one.Models;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


//Entity class representing an order made by a customer.

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Customer's name associated with the order
    @Column
    @NotBlank
    private String customerName;

    // Date when the order was placed
    @Column
    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date orderDate;

    // Status of the order (e.g., 'Pending', 'Cancelled', 'Completed')
    @Column
    @NotBlank
    private String status;

    // Customer's address associated with the order
    @Column
    @NotBlank
    private String customerAddress;

    // One-to-Many relationship with OrderItem entities.
    // Each order can have multiple items.
    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    // Getters and Setters
    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    @Override
    public String toString() {
        return "Orders [id=" + id + ", customerName=" + customerName + ", orderDate=" + orderDate + ", status=" + status
                + ", customerAddress=" + customerAddress + "]";
    }

    
}
