package org.atr.customer.service;


import org.atr.customer.dto.CustomerDTO;
import org.atr.customer.dto.PurchaseDTO;
import org.atr.customer.entity.Customer;
import org.atr.customer.entity.Purchase;

import java.util.Optional;

public interface CustomerPurchaseService {


    Optional<Customer> selectAllPurchasesOfCustomer(Integer id);

    Optional<Purchase> addPurchase(CustomerDTO customerDTO,PurchaseDTO purchaseDTO);


}
