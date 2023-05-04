package org.atr.operations.controller;

import org.atr.operations.dto.OperationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @PostMapping("/create")
    public ResponseEntity<OperationDTO> createOperation(@RequestBody final OperationDTO operationDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<OperationDTO> readOperationById(@RequestParam final Integer id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PutMapping("/update")
    public ResponseEntity<OperationDTO> updateOperation(@RequestBody final OperationDTO operationDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<OperationDTO> deleteOperation(@RequestBody final OperationDTO operationDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping("/read/all")
    public ResponseEntity<List<OperationDTO>> readAllOperation(){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


}
