package com.iconic.keygenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iconic.keygenerator.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
}
