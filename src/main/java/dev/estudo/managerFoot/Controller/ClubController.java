package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.request.CreateClubRequest;
import dev.estudo.managerFoot.Controller.response.ClubDetailResponse;
import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Controller.response.PlayerResponse;
import dev.estudo.managerFoot.Mapper.ClubMapper;
import dev.estudo.managerFoot.Service.ClubService;
import dev.estudo.managerFoot.Service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;
    private final ClubMapper clubMapper;
    private final PlayerService playerService;

    public ClubController(ClubService clubService, ClubMapper clubMapper, PlayerService playerService) {
        this.clubService = clubService;
        this.clubMapper = clubMapper;
        this.playerService = playerService;
    }

    @GetMapping("/readAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable){
        return clubService.readAll(pageable);
    }

    @GetMapping("/{id}")
    public ClubDetailResponse findAllId(@PathVariable Long id){
        return clubMapper.toClubDetailResponse(clubService.findById(id));
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDetailResponse create(@Valid @RequestBody CreateClubRequest request){
        return clubService.create(request);
    }

    @GetMapping("/{id}/players")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerResponse> findPlayersClub(@PathVariable Long id){
        return playerService.findPlayers(id);
    }
}
