package org.atr.operations.service;

import org.atr.operations.entity.Operation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OperationService {

    Optional<Operation> createOperation(String description, BigDecimal totalAmount, Date operationDate);

    boolean deleteOperationById();
    Optional<Operation> updateOperation();

    Optional<Operation> selectOperationById();

    Optional<List<Operation>> selectAllOperations();

}
