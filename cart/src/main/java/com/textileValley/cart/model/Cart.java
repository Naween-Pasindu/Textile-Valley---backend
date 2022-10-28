package com.textileValley.cart.model;

import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "cart")
public class Cart {
    @Id
    private long cartId;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Buyer> buyerId = new ArrayList<>();

}
