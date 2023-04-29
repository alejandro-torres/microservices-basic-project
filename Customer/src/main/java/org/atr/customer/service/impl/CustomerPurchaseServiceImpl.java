package org.atr.customer.service.impl;

import org.atr.customer.dto.CustomerDTO;
import org.atr.customer.dto.PurchaseDTO;
import org.atr.customer.entity.Customer;
import org.atr.customer.entity.Purchase;
import org.atr.customer.service.CustomerPurchaseService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerPurchaseServiceImpl implements CustomerPurchaseService {
    @Override
    public Optional<Customer> selectAllPurchasesOfCustomer(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Purchase> addPurchase(CustomerDTO customerDTO, PurchaseDTO purchaseDTO) {
        return Optional.empty();
    }
}
