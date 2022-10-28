package com.textileValley.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="itemName")
    private String itemName;

    @Column(name = "seller")
    private  long seller;

    @Column(name = "price")
    private Double price;

}
