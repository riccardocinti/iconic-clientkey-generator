package com.iconic.keygenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iconic.keygenerator.models.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long>{

}
