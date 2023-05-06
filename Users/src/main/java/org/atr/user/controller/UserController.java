package org.atr.user.controller;

import org.atr.user.DTO.UserDTO;
import org.atr.user.DTO.UserSecuredDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    //@Secured("ADMIN")
    @PostMapping("/create")
    public ResponseEntity<UserSecuredDTO> createUser(@RequestBody final UserSecuredDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    //@Secured("ADMIN")
    @GetMapping("/read")
    public ResponseEntity<UserSecuredDTO> readUser(@RequestBody final UserSecuredDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    //@Secured("ADMIN")
    @PutMapping("/update")
    public ResponseEntity<UserSecuredDTO> updateUser(@RequestBody final UserSecuredDTO userDTO){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    //@Secured("ADMIN")
    @DeleteMapping("/delete")
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
