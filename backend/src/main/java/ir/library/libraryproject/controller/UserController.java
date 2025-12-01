package ir.library.libraryproject.controller;

import ir.library.libraryproject.Model.User;
import ir.library.libraryproject.Service.User.UserService;
import ir.library.libraryproject.dto.request.UserRequest;
import ir.library.libraryproject.dto.request.UserSinginRequest;
import ir.library.libraryproject.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @GetMapping("/singin")
    public ResponseEntity<?> singin(@RequestBody @Valid UserSinginRequest userSinginRequest){
        userService.singin(userSinginRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/enabled/{id}/{enable}")
    public ResponseEntity<?> changeEnableUser(@PathVariable Boolean enable,@PathVariable Long id){
        userService.changeEnable(enable,id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUser(Pageable pageable){
        return ResponseEntity.ok(userService.findAll(pageable));
    }
    //if you want change size or page when send the request use this parameters
    // http://localhost:8080/users?page=3&size=2

}
