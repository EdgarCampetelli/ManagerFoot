package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Entity.Club;
import dev.estudo.managerFoot.Mapper.ClubMapper;
import dev.estudo.managerFoot.Repository.ClubRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;
    public ClubService(ClubRepository clubRepository, ClubMapper clubMapper) {
        this.clubRepository = clubRepository;
        this.clubMapper = clubMapper;
    }

    public Page<ClubResponse> readAll(Pageable pageable){
        return clubRepository.findAll(pageable)
                .map(clubMapper::clubResponse);
    }
}
