package com.textileValley.cart.repository;

import com.textileValley.cart.model.Buyer;
import com.textileValley.cart.model.Cart;
import com.textileValley.cart.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IcartRepository  extends JpaRepository<Cart, Long> {

    @Query("SELECT OBJECT() FROM item,cart_item,cart WHERE item.item_Id=cart_item.item_id AND cart_item.cart_id=cart.cart_id AND cart.buyer_id= :buyerId")
    List<Item> getItemByBuyerId(@Param("buyerId") Long buyerId);

    @Query("FROM buyer,cart WHERE buyer.user_Id=cart.buyer_id AND cart.buyer_id= :buyerId")
    Buyer getBuyerByBuyerId(@Param("buyerId") Long buyerId);

    Optional<Cart> findCartByBuyerId(Long buyerId);
}
