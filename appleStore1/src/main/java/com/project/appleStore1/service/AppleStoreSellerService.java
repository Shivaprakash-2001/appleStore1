//package com.project.appleStore1.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.appleStore1.entityAppleStore.AppleStoreSeller;
//import com.project.appleStore1.repository.SellerRepository;
//
//@Service
//public class AppleStoreSellerService {
//
//	@Autowired
//	private SellerRepository sellerRepository;
//
//	public String buyProduct(long modelNumber, int quantity) {
//		Optional<AppleStoreSeller> sellerOptional = sellerRepository.findById(modelNumber);
//
//		if (sellerOptional.isPresent()) {
//			AppleStoreSeller seller = sellerOptional.get();
//
//			if (seller.getAvailable_Stocks() >= quantity) {
//				int newStocksSold = seller.getStocks_Sold() + quantity;
//				int newAvailableStocks = seller.getAvailable_Stocks() - quantity;
//
//				seller.setStocks_Sold(newStocksSold);
//				seller.setAvailable_Stocks(newAvailableStocks);
//
//				sellerRepository.save(seller);
//
//				return "Successfully bought " + quantity + " " + seller.getProduct_Name();
//			} else {
//				return "Insufficient quantity of " + seller.getProduct_Name() + " available." + "Only there are "
//						+ seller.getAvailable_Stocks() + " Available ";
//			}
//		} else {
//			return "Product with model number " + modelNumber + " not found.";
//		}
//	}
//}
//
//package com.project.appleStore1.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.project.appleStore1.entityAppleStore.AppleStoreSeller;
//import com.project.appleStore1.repository.SellerRepository;
//
//@Service
//public class AppleStoreSellerService {
//
//	@Autowired
//	private SellerRepository sellerRepository;
//
//	public String buyProduct(long modelNumber, int quantity) {
//		AppleStoreSeller seller = sellerRepository.findById(modelNumber).orElse(null);
//
//		if (seller == null) {
//			return "Product with model number " + modelNumber + " not found.";
//		}
//
//		if (seller.getAvailable_Stocks() < quantity) {
//			return "Insufficient quantity of " + seller.getProduct_Name() + " available. Only "
//					+ seller.getAvailable_Stocks() + " Available.";
//		}
//
//		int newStocksSold = seller.getStocks_Sold() + quantity;
//		int newAvailableStocks = seller.getAvailable_Stocks() - quantity;
//
//		seller.setStocks_Sold(newStocksSold);
//		seller.setAvailable_Stocks(newAvailableStocks);
//
//		sellerRepository.save(seller);
//
//		return "Successfully bought " + quantity + " " + seller.getProduct_Name();
//	}
//}

package com.project.appleStore1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.appleStore1.entityAppleStore.AppleStoreSeller;
import com.project.appleStore1.repository.SellerRepository;

@Service
public class AppleStoreSellerService {

	@Autowired
	private SellerRepository sellerRepository;

	public BuyProductResponse buyProduct(int modelNumber, int quantity) {
		AppleStoreSeller seller = sellerRepository.findById(modelNumber).orElse(null);
		BuyProductResponse response = new BuyProductResponse();

		if (seller == null) {
			response.setMessage("Product with model number " + modelNumber + " not found.");
			return response;
		}

		if (seller.getAvailable_Stocks() < quantity) {
			response.setMessage("Insufficient quantity of " + seller.getProduct_Name() + " available. Only "
					+ seller.getAvailable_Stocks() + " Products Available.");
			return response;
		}

		seller.setStocks_Sold(seller.getStocks_Sold() + quantity);
		seller.setAvailable_Stocks(seller.getAvailable_Stocks() - quantity);

		sellerRepository.save(seller);

		response.setMessage("Successfully bought " + quantity + " " + seller.getProduct_Name());
		return response;
	}
}
