package com.textileValley.item.service;

import com.textileValley.item.model.Items;
import com.textileValley.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemsServiceImp implements ItemsService{

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public String addItems(String itemName, String price, int seller) {

        Items item = new Items();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setSeller(seller);

        itemRepository.save(item);

        return null;
    }
}
