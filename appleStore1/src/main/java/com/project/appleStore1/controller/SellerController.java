package com.project.appleStore1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.appleStore1.entityAppleStore.AppleStoreSeller;
import com.project.appleStore1.exception.ProductNotFoundException;
import com.project.appleStore1.repository.SellerRepository;

@RestController
@RequestMapping("/api/product")
public class SellerController {

	@Autowired
	private SellerRepository sellerRepository;

	// get all Products
	@GetMapping("/visitiplanet")
	public List<AppleStoreSeller> getAllProducts() {
		return this.sellerRepository.findAll();
	}

	// Updating new products in the store
	@PostMapping("/post")
	public AppleStoreSeller createSeller(@RequestBody AppleStoreSeller seller) {
		return this.sellerRepository.save(seller);
	}

	// Deleting the old products from the store
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Admin> deleteUser(@PathVariable("id") int modelNumber) {
		this.sellerRepository.deleteById(modelNumber);
		return ResponseEntity.ok().build();
	}

	// Find product by its Model Number
	@GetMapping("/findbyModel/{id}")
	public Optional<AppleStoreSeller> getModelNumber(@PathVariable(value = "id") int modelNumber) {
		Optional<AppleStoreSeller> appleStoreSeller = sellerRepository.findById(modelNumber);
		if (appleStoreSeller.isPresent()) {
			return appleStoreSeller;
		} else {
			throw new ProductNotFoundException("This Model Number " + modelNumber + " Not found");
		}
	}

}
