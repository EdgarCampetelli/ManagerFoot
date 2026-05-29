package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.request.StadiumRequest;
import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Service.StadiumService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/post-stadium")
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse creat(@RequestBody StadiumRequest stadiumRequest){
        return  stadiumService.creat(stadiumRequest);
    }

}
