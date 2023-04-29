package org.atr.customer.repository;

import org.atr.customer.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPurchaseRepository extends JpaRepository<Purchase,Integer> {
}
