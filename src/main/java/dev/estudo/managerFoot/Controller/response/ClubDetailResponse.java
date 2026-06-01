package dev.estudo.managerFoot.Controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClubDetailResponse {

    private Long id;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate founded;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String url_img;

    private StadiumResponse stadium;
}
