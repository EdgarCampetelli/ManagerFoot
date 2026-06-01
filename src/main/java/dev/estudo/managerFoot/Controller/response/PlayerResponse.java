package dev.estudo.managerFoot.Controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.estudo.managerFoot.Entity.Position;
import lombok.Data;

@Data
public class PlayerResponse {

    private Long id;
    private String name;
    private String position;
    private int shirtNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url_img;
}
