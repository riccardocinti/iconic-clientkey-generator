package com.iconic.keygenerator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iconic.keygenerator.models.ClientKey;

public interface ClientKeyRepository extends JpaRepository<ClientKey, String> {
	List<ClientKey> findAllByOrderByClientAsc();
}
