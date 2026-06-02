package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.exception.ResourceNotFoundException;
import dev.estudo.managerFoot.Controller.request.PlayerRequest;
import dev.estudo.managerFoot.Controller.response.ClubDetailResponse;
import dev.estudo.managerFoot.Controller.response.PlayerResponse;
import dev.estudo.managerFoot.Controller.response.PlayesDetailResponse;
import dev.estudo.managerFoot.Entity.Player;
import dev.estudo.managerFoot.Mapper.ClubMapper;
import dev.estudo.managerFoot.Mapper.PlayerMapper;
import dev.estudo.managerFoot.Repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final ClubService clubService;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper, ClubService clubService, ClubMapper clubMapper) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.clubService = clubService;
    }

    public Page<PlayerResponse> findAll(Pageable pageable){
        return playerRepository.findAll(pageable).map(playerMapper::toResponse);
    }

    public PlayesDetailResponse findById(Long id){
        return playerMapper.toDetailResponse(playerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Player whit id "+id+" not found.")));
    }

    public PlayesDetailResponse create(PlayerRequest request){
        Player newPlayer = playerMapper.toPlayer(request);
        newPlayer.setClub(clubService.findById(request.getClubId()));
        return playerMapper.toDetailResponse(playerRepository.save(newPlayer));
    }

    public List<PlayerResponse> findPlayers(Long clubId){
        return playerRepository.findByClubId(clubId)
                .stream()
                .map(playerMapper::toResponse)
                .toList();
    }
}
