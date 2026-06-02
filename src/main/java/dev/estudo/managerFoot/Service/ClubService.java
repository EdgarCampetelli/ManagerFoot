package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.exception.ResourceNotFoundException;
import dev.estudo.managerFoot.Controller.request.CreateClubRequest;
import dev.estudo.managerFoot.Controller.response.ClubDetailResponse;
import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Controller.response.PlayerResponse;
import dev.estudo.managerFoot.Entity.Club;
import dev.estudo.managerFoot.Mapper.ClubMapper;
import dev.estudo.managerFoot.Mapper.StadiumMapper;
import dev.estudo.managerFoot.Repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository clubRepository;
    private final StadiumService stadiumService;
    private final ClubMapper clubMapper;
    public ClubService(ClubRepository clubRepository, StadiumService stadiumService, StadiumMapper stadiumMapper, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.stadiumService = stadiumService;
        this.clubMapper = clubMapper;
    }

    public Page<ClubResponse> readAll(Pageable pageable){
        return clubRepository.findAll(pageable)
                .map(clubMapper::clubResponse);
    }

    public Club findById(Long id){
        return clubRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Club not found for id: "+id));
    }

    public ClubDetailResponse create(CreateClubRequest request){
        Club club = clubMapper.toClub(request);
        if (Objects.nonNull(club.getStadium())){
            club.setStadium(stadiumService.findById(club.getStadium().getId()));
        }
        clubRepository.save(club);
        return clubMapper.toClubDetailResponse(club);
    }
}
