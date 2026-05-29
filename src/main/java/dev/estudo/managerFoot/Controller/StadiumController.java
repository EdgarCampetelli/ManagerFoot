package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Service.StadiumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final StadiumService stadiumService;
    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }


    @GetMapping("/readAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<StadiumResponse> listStadiums(Pageable pageable){
        return stadiumService.getAllStadium(pageable);
    }

}
