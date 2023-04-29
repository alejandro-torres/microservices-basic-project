package org.atr.customer.service;

import org.atr.customer.dto.CustomerDTO;
import org.atr.customer.entity.Customer;

import java.util.Optional;

public interface CustomerService {


    Optional<Customer> createCustomer(CustomerDTO customerDTO);

    boolean deleteCustomerById(Integer id);

    Optional<Customer> updateCustomer(CustomerDTO customerDTO);

    Optional<Customer> selectCustomerById(Integer id);


}
