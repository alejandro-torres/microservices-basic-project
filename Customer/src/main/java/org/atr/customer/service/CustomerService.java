package org.atr.customer.service;

import org.atr.customer.entity.Customer;
import org.atr.customer.entity.Purchase;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerService {


    Optional<Customer> createCustomer(String name, String email);

    boolean deleteCustomerById(Integer id);

    Optional<Customer> updateCustomer(Integer id, String name, String email);

    Optional<Customer> selectCustomerById(Integer id);

    Optional<Purchase> addPurchase(Integer customerId, String name, BigDecimal value, Date purchaseDate);

    Optional<List<Purchase>> selectPurchaseListById(Integer id);


}
