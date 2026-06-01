package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.request.CreateClubRequest;
import dev.estudo.managerFoot.Controller.response.ClubDetailResponse;
import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Mapper.ClubMapper;
import dev.estudo.managerFoot.Service.ClubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;
    private final ClubMapper clubMapper;

    public ClubController(ClubService clubService, ClubMapper clubMapper) {
        this.clubService = clubService;
        this.clubMapper = clubMapper;
    }

    @GetMapping("/readAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable){
        return clubService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public ClubDetailResponse findAllId(@PathVariable Long id){
        return clubService.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDetailResponse create(@RequestBody CreateClubRequest request){
        return clubService.create(request);
    }
}
