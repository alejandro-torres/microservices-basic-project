package org.atr.operations.service.impl;

import org.atr.operations.entity.Operation;
import org.atr.operations.repository.OperationRepository;
import org.atr.operations.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Override
    public Optional<Operation> createOperation(String description, BigDecimal totalAmount, Date operationDate) {

        Operation operation = Operation.builder()
                .description(description)
                .totalAmount(totalAmount)
                .date(operationDate)
                .build();

        return Optional.of(operationRepository.save(operation));
    }

    @Override
    public boolean deleteOperationById(Integer id) {
        try{
            operationRepository.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            Logger log = Logger.getLogger(this.getClass().getName());
            log.log(Level.SEVERE, e.getMessage());
            return false;
        }
    }

    @Override
    public Optional<Operation> selectOperationById(Integer id) {
        return operationRepository.findById(id);
    }

    @Override
    public Optional<List<Operation>> selectAllOperations() {
        return Optional.of(operationRepository.findAll());
    }
}
