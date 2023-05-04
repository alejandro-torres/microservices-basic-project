package org.atr.customer.service.impl;


import org.atr.customer.entity.Customer;
import org.atr.customer.entity.Purchase;
import org.atr.customer.repository.CustomerRepository;
import org.atr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> createCustomer(String name, String email) {
        Customer customer = Customer.builder()
                .name(name)
                .email(email)
                .build();
        return Optional.of(customerRepository.save(customer));
    }

    @Override
    public boolean deleteCustomerById(Integer id) {
        try{
            customerRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            Logger log = Logger.getLogger(this.getClass().getName());
            log.log(Level.SEVERE, e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Customer> updateCustomer(Integer id, String name, String email) {
        Optional<Customer> checkCustomer = customerRepository.findById(id);
        if (checkCustomer.isEmpty()){
            return Optional.empty();
        }else {
            //TODO: update the list as well! this method just deleted the purchaseList
            Customer customer = Customer.builder()
                    .id(id)
                    .name(name)
                    .email(email)
                    .purchaseList(new ArrayList<Purchase>())
                    .build();
            return Optional.of(customerRepository.save(customer));
        }
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> addPurchase(Integer customerId, String name, BigDecimal value, Date purchaseDate) {
        return Optional.empty();
    }

}
