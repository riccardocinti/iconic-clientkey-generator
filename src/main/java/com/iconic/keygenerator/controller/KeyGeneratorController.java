package com.iconic.keygenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iconic.keygenerator.models.Client;
import com.iconic.keygenerator.models.ClientKey;
import com.iconic.keygenerator.models.Subscription;
import com.iconic.keygenerator.repository.ClientKeyRepository;
import com.iconic.keygenerator.repository.ClientRepository;
import com.iconic.keygenerator.repository.SubscriptionRepository;

@RestController
public class KeyGeneratorController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ClientKeyRepository clientKeyRepository;
	
	@Autowired
	SubscriptionRepository subscriptionRepository;
	
	@RequestMapping(value = "/subscription/add", method = RequestMethod.POST)
	public void saveClient(@RequestBody Subscription subscription) {
		clientRepository.save(subscription.getClientKey().getClient());
		clientKeyRepository.save(subscription.getClientKey());
		subscriptionRepository.save(subscription);
	}
	
	@RequestMapping(value = "/clients/list", method = RequestMethod.GET)
	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	@RequestMapping(value = "/clients/keys", method = RequestMethod.GET)
	public List<ClientKey> getClientKeys(){
		return clientKeyRepository.findAllByOrderByClientAsc();
	}
	
	@RequestMapping(value = "/clients/subscriptions", method = RequestMethod.GET)
	public List<Subscription> getSubscriptions(){
		return subscriptionRepository.findAll();
	}
}
