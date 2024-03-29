package org.atr.operations.service;

import org.atr.operations.entity.Operation;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OperationService {

    Optional<Operation> createOperation(String description, BigDecimal totalAmount, Date operationDate);

    boolean deleteOperationById(Integer id);

    Optional<Operation> selectOperationById(Integer id);

    Optional<List<Operation>> selectAllOperations();

}
