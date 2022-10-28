package com.textileValley.authentication.repository;

import com.textileValley.authentication.model.login;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<login, String> {

	login findByuserName(String userName);

};