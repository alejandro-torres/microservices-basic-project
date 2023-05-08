package org.atr.users.controller;

import org.atr.users.DTO.UserDTO;
import org.atr.users.DTO.UserSecuredDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UsersController {

    //@Secured("ADMIN")
    @PostMapping("/manager/create")
    public ResponseEntity<UserSecuredDTO> createUser(@RequestBody final UserSecuredDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    //@Secured("ADMIN")
    @GetMapping("/manager/read/{id}")
    public ResponseEntity<UserSecuredDTO> readUserById(@PathVariable final Integer id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    //@Secured("ADMIN")
    @PutMapping("/manager/update")
    public ResponseEntity<UserSecuredDTO> updateUser(@RequestBody final UserSecuredDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    //@Secured("ADMIN")
    @DeleteMapping("/manager/delete")
    public ResponseEntity<UserSecuredDTO> deleteUser(@RequestBody final UserSecuredDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/validate/pass")
    public ResponseEntity<UserDTO> validateUserPassword(@RequestBody final UserDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping("/validate/email")
    public ResponseEntity<UserDTO> validateUserEmail(@RequestBody final UserDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
