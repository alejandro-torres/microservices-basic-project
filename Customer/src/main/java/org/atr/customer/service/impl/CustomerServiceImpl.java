package org.atr.customer.service.impl;

import org.atr.customer.dto.CustomerDTO;
import org.atr.customer.entity.Customer;
import org.atr.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Optional<Customer> createCustomer(CustomerDTO customerDTO) {
        return Optional.empty();
    }

    @Override
    public boolean deleteCustomerById(Integer id) {
        return false;
    }

    @Override
    public Optional<Customer> updateCustomer(CustomerDTO customerDTO) {
        return Optional.empty();
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return Optional.empty();
    }
}
