package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.request.PlayerRequest;
import dev.estudo.managerFoot.Controller.response.PlayerResponse;
import dev.estudo.managerFoot.Controller.response.PlayesDetailResponse;
import dev.estudo.managerFoot.Service.PlayerService;
import dev.estudo.managerFoot.config.security.annotations.CanReadPlayer;
import dev.estudo.managerFoot.config.security.annotations.CanWritePlayer;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @CanReadPlayer
    @GetMapping("/readAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<PlayerResponse> readAll(Pageable pageable){
        return playerService.findAll(pageable);
    }

    @CanReadPlayer
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayesDetailResponse findById(@PathVariable Long id){
        return playerService.findById(id);
    }

    @CanWritePlayer
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayesDetailResponse create(@Valid @RequestBody PlayerRequest request){
        return playerService.create(request);
    }

}
