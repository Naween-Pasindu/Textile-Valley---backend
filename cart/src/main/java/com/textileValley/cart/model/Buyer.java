package com.textileValley.cart.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "contact")
    private String contact;
    @OneToMany(mappedBy = "buyerId")
    private List<Cart> cart;

}
