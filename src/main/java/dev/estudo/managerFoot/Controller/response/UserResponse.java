package dev.estudo.managerFoot.Controller.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private String name;
    private String email;
    private List<String> scopes;
}
