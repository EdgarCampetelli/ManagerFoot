package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.request.UserRequest;
import dev.estudo.managerFoot.Controller.response.UserResponse;
import dev.estudo.managerFoot.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse create(@Valid @RequestBody UserRequest request){
        return userService.create(request);
    }
}
