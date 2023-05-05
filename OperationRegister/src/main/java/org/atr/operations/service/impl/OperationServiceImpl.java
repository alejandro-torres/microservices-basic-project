package org.atr.operations.service.impl;

import org.atr.operations.entity.Operation;
import org.atr.operations.service.OperationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OperationServiceImpl implements OperationService {
    @Override
    public Optional<Operation> createOperation(String description, BigDecimal totalAmount, Date operationDate) {
        return Optional.empty();
    }

    @Override
    public boolean deleteOperationById() {
        return false;
    }

    @Override
    public Optional<Operation> selectOperationById() {
        return Optional.empty();
    }

    @Override
    public Optional<List<Operation>> selectAllOperations() {
        return Optional.empty();
    }
}
