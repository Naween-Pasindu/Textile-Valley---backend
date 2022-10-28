package com.textileValley.item.repository;

import com.textileValley.item.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ItemRepository extends JpaRepository<Items, Integer> {

	List<Items> findByseller(int seller);

	Items findByitemId(int seller);

	void deleteByitemId(int itemId);
};