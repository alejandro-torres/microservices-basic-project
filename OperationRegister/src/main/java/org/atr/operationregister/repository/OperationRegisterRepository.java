package org.atr.operationregister.repository;

import org.atr.operationregister.entity.OperationRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRegisterRepository extends JpaRepository<OperationRegister, Integer> {
}
