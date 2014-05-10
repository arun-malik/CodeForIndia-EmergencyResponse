package com.codeforindia.emrgncyres.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeforindia.emrgncyres.model.Admin;


public interface AdminRepo extends JpaRepository<Admin , Integer> {

	 public Admin findByUsername(String username);

	
}
