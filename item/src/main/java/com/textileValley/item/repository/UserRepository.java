package com.textileValley.item.repository;

import com.textileValley.item.model.login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<login, String> {

	login findByuserName(String userName);

};