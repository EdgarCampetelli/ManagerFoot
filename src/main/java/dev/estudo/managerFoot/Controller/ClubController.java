package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable){
        return clubService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public void findAllId(@PathVariable Long id){

    }

    @PostMapping("/create")
    public void create(@RequestBody ClubResponse clubResponse){

    }
}
