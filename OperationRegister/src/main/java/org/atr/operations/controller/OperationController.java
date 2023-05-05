package org.atr.operations.controller;

import org.atr.operations.dto.OperationDTO;
import org.atr.operations.dto.OperationListDTO;
import org.atr.operations.entity.Operation;
import org.atr.operations.service.impl.OperationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationServiceImpl operationService;

    @PostMapping("/create")
    public ResponseEntity<OperationDTO> createOperation(@RequestBody final OperationDTO operationDTO){
        Optional<Operation> operation = operationService.createOperation(operationDTO.getDescription(),operationDTO.getTotalAmount(),operationDTO.getDate());

        if (operation.isEmpty())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        OperationDTO response = OperationDTO.builder()
                .id(operation.get().getId())
                .description(operation.get().getDescription())
                .totalAmount(operation.get().getTotalAmount())
                .date(operation.get().getDate())
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<OperationDTO> readOperationById(@PathVariable final Integer id){
        Optional<Operation> operation = operationService.selectOperationById(id);
        if (operation.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        OperationDTO response = OperationDTO.builder()
                .id(operation.get().getId())
                .description(operation.get().getDescription())
                .totalAmount(operation.get().getTotalAmount())
                .date(operation.get().getDate())
                .build();

        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/read/all")
    public ResponseEntity<OperationListDTO> readAllOperation(){

        Optional<List<Operation>> operationList = operationService.selectAllOperations();

        if (operationList.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        OperationListDTO response = new OperationListDTO();
        List<OperationDTO> operationListDTO = new ArrayList<>();

        for (Operation op: operationList.get()) {
            OperationDTO operationDTO = OperationDTO.builder()
                    .id(op.getId())
                    .description(op.getDescription())
                    .totalAmount(op.getTotalAmount())
                    .date(op.getDate())
                    .build();
            operationListDTO.add(operationDTO);
        }
        response.setOperationList(operationListDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<OperationDTO> deleteOperation(@RequestBody final OperationDTO operationDTO){
        if(operationService.deleteOperationById(operationDTO.getId())){
            return new ResponseEntity<>(operationDTO, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
