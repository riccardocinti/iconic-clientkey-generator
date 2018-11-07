package com.iconic.keygenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Client>> getClients() {
		return new ResponseEntity<List<Client>>(clientRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value = "/clients/keys")
	public ResponseEntity<List<ClientKey>> getClientKeys(){
		return new ResponseEntity<List<ClientKey>>(clientKeyRepository.findAllByOrderByClientAsc(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/clients/subscriptions")
	public ResponseEntity<List<Subscription>> getSubscriptions(){
		return new ResponseEntity<List<Subscription>>(subscriptionRepository.findAll(), HttpStatus.OK);
	}
}
