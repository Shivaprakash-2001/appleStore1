package com.project.appleStore1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.appleStore1.service.AppleStoreSellerService;
import com.project.appleStore1.service.BuyProductResponse;

@RestController
@RequestMapping("/api/products")
public class AppleStoreSellerController {

	@Autowired
	private AppleStoreSellerService sellerService;

	@PutMapping("/purchase")
	public ResponseEntity<BuyProductResponse> buyProduct(@RequestParam int modelNumber, @RequestParam int quantity) {
		BuyProductResponse response = sellerService.buyProduct(modelNumber, quantity);
		return ResponseEntity.ok(response);
	}

//	@PostMapping("/purchase")
//	public ResponseEntity<BuyProductResponse> buyProduct(@RequestParam int modelNumber, @RequestParam int quantity) {
//		BuyProductResponse response = sellerService.buyProduct(modelNumber, quantity);
//		return ResponseEntity.ok(response);
//	}
}
