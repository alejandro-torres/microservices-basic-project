package org.atr.customer.service;

import org.atr.customer.entity.Customer;
import org.atr.customer.entity.Purchase;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CustomerService {


    Optional<Customer> createCustomer(String name, String email);

    boolean deleteCustomerById(Integer id);

    Optional<Customer> updateCustomer(Integer id, String name, String email);

    Optional<Customer> selectCustomerById(Integer id);

    Optional<Purchase> addPurchase(Integer customerId, List<Integer> productIdList, Date purchaseDate);

    Optional<List<Purchase>> selectPurchaseListByCustomerId(Integer id);


}
