package com.iconic.keygenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iconic.keygenerator.models.Client;
import com.iconic.keygenerator.models.ClientKey;
import com.iconic.keygenerator.models.Subscription;
import com.iconic.keygenerator.repository.ClientKeyRepository;
import com.iconic.keygenerator.repository.ClientRepository;
import com.iconic.keygenerator.repository.SubscriptionRepository;

@RestController
@RequestMapping("/keyhandling")
public class KeyGeneratorController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientKeyRepository clientKeyRepository;
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@PostMapping(value = "/subscription/add")
	public void saveClient(@RequestBody Subscription subscription) {
		clientRepository.save(subscription.getClientKey().getClient());
		clientKeyRepository.save(subscription.getClientKey());
		subscriptionRepository.save(subscription);
	}
	
	@GetMapping(value = "/clients/list")
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@GetMapping(value = "/clients/keys")
	public List<ClientKey> getClientKeys(){
		return clientKeyRepository.findAllByOrderByClientAsc();
	}
	
	@GetMapping(value = "/clients/subscriptions")
	public List<Subscription> getSubscriptions(){
		return subscriptionRepository.findAll();
	}
}
