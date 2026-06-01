package dev.estudo.managerFoot.Controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class PlayesDetailResponse {
    private Long id;
    private String name;
    private String position;
    private int shirtNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url_img;
    private ClubResponse club;
}
