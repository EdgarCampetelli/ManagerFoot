package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.request.LoginRequest;
import dev.estudo.managerFoot.Controller.response.LoginResponse;
import dev.estudo.managerFoot.Service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest request){
        return loginService.login(request);
    }
}
