package com.textileValley.item.controller;

import com.textileValley.item.model.Items;
import com.textileValley.item.repository.ItemRepository;
import com.textileValley.item.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ManageItemsController {

    @Autowired
    private ItemRepository itemRepository;


    @PostMapping("/textile-valley/seller/addItems")
    public ResponseEntity<?> addItems(@RequestBody Items items) {

        itemRepository.save(items);

        return null;
    }

    //	display items
    @GetMapping("/textile-valley/users")
    public List<Items> findAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/textile-valley/users/{id}")
    public List<Items> findItems(@PathVariable int id) {

        return itemRepository.findByseller(id);
    }

    //	update item
    @PutMapping("/textile-valley/seller/update")
    public Items updateProduct(@RequestBody Items product) {

        Items item = itemRepository.findByitemId(product.getItemId());
        System.out.println(product.getItemId());
        item.setItemName(product.getItemName());
        item.setPrice(product.getPrice());
        System.out.println("sucess");
        return itemRepository.save(item);
    }

    //	delete item
    @DeleteMapping("/textile-valley/seller/delete/{id}")
    public String deleteProduct(@PathVariable int id) {

        Items item = itemRepository.findByitemId(id);
        System.out.println(id);
        itemRepository.delete(item);
        return "product removed !! " + id;
    }
}
