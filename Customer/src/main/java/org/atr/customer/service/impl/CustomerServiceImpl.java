package org.atr.customer.service.impl;


import org.atr.customer.dto.ProductDTO;
import org.atr.customer.dto.ProductListDTO;
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


import java.math.BigDecimal;
import java.util.*;
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
    public Optional<Purchase> addPurchase(Integer customerId, List<Integer> productIdList, Date purchaseDate) {

        Optional<Customer> customerOfPurchase = customerRepository.findById(customerId);
        if (customerOfPurchase.isEmpty()){
            Logger logger = Logger.getLogger(this.getClass().getName());
            logger.log(Level.SEVERE, "No Customer for Purchase");
            return Optional.empty();
        }
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ProductListDTO> readProductResponse = restTemplate.postForEntity(
                "http://localhost:8080/product/read/all",
                productIdList,
                ProductListDTO.class);

        Iterator<ProductDTO> iterator = readProductResponse.getBody().getProductListDTO().iterator();
        BigDecimal totalAmount = new BigDecimal(0);
        List<Integer> productIDListResponse = new ArrayList<>();

        while (iterator.hasNext()){
            ProductDTO productDTO = iterator.next();
            totalAmount = totalAmount.add(productDTO.getValue());
            productIDListResponse.add(productDTO.getId());
        }

        Purchase purchase = Purchase.builder()
                .totalAmount(totalAmount)
                .purchaseDate(purchaseDate)
                .customer(customerOfPurchase.get())
                .productIdList(productIDListResponse)
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
