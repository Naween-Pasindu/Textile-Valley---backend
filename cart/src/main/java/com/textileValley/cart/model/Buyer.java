package com.textileValley.cart.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;
}
