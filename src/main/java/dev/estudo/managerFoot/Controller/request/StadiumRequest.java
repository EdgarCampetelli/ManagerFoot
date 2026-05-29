package dev.estudo.managerFoot.Controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StadiumRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String city;
    private Integer capacity;
    private String urlImg;

}