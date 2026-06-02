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
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyAuthority('SCOPE_club:read','SCOPE_admin:all')")
    @GetMapping("/readAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable){
        return clubService.readAll(pageable);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_club:read','SCOPE_admin:all')")
    @GetMapping("/{id}")
    public ClubDetailResponse findAllId(@PathVariable Long id){
        return clubMapper.toClubDetailResponse(clubService.findById(id));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_club:write','SCOPE_admin:all')")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDetailResponse create(@Valid @RequestBody CreateClubRequest request){
        return clubService.create(request);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_club:read','SCOPE_admin:all')")
    @GetMapping("/{id}/players")
    @ResponseStatus(HttpStatus.OK)
    public List<PlayerResponse> findPlayersClub(@PathVariable Long id){
        return playerService.findPlayers(id);
    }
}
