package com.senforage.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.senforage.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	public Page<Client> findByNomContains(String mc, Pageable pageable);
	
}
