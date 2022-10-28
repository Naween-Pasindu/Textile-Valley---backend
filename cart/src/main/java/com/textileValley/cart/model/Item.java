package com.textileValley.cart.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="itemName")
    private String itemName;

    @Column(name = "seller")
    private  long seller;

    @Column(name = "price")
    private Double price;

}
