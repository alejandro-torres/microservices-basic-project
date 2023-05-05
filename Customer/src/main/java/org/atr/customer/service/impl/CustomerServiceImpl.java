package org.atr.customer.service.impl;


import org.atr.customer.dto.ProductDTO;
import org.atr.customer.entity.Customer;
import org.atr.customer.entity.Purchase;
import org.atr.customer.repository.CustomerRepository;
import org.atr.customer.repository.PurchaseRepository;
import org.atr.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PurchaseRepository purchaseRepository;



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
            Optional<List<Purchase>> purchaseList = selectPurchaseListByCustomerId(id);
            Customer customer = Customer.builder()
                    .id(id)
                    .name(name)
                    .email(email)
                    .purchaseList(purchaseList.get())
                    .build();
            return Optional.of(customerRepository.save(customer));
        }
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Purchase> addPurchase(Integer customerId, Integer productId, Date purchaseDate) {

        Optional<Customer> customerOfPurchase = customerRepository.findById(customerId);
        if (customerOfPurchase.isEmpty()){
            Logger logger = Logger.getLogger(this.getClass().getName());
            logger.log(Level.SEVERE, "No Customer for Purchase");
            return Optional.empty();
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductDTO> readProductResponse = restTemplate.getForEntity("http://localhost:8080/product/read/{id}",
                ProductDTO.class,
                productId);


        Purchase purchase = Purchase.builder()
                .value(readProductResponse.getBody().getValue())
                .name(readProductResponse.getBody().getName())
                .purchaseDate(purchaseDate)
                .customer(customerOfPurchase.get())
                .productId(readProductResponse.getBody().getId())
                .build();

        return Optional.of(purchaseRepository.save(purchase));
    }

    @Override
    public Optional<List<Purchase>> selectPurchaseListByCustomerId(Integer id) {
        Optional<Customer> customer= customerRepository.findById(id);
        if (customer.isEmpty()){
            Logger logger = Logger.getLogger(this.getClass().getName());
            logger.log(Level.SEVERE, "No Customer data found");
            return Optional.empty();
        }
        return Optional.ofNullable(customer.get().getPurchaseList());
    }

}
