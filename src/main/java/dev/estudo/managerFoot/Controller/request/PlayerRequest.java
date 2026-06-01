package dev.estudo.managerFoot.Controller.request;

import dev.estudo.managerFoot.Entity.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerRequest {

    @NotBlank
    private String name;
    @NotNull
    private Position position;
    @NotNull
    private int shirtNumber;
    private String url_img;
    @NotNull
    private Long clubId;

}
