package com.project.appleStore1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.appleStore1.entityAppleStore.AppleStoreSeller;

@Repository
public interface SellerRepository extends JpaRepository<AppleStoreSeller, Integer> {

}
