package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Mapper.StadiumMapper;
import dev.estudo.managerFoot.Repository.StadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;

    public StadiumService(StadiumRepository stadiumRepository) {
        this.stadiumRepository = stadiumRepository;
    }

    public Page<StadiumResponse> getAllStadium(Pageable pageable){
        return stadiumRepository.findAll(pageable)
                .map(StadiumMapper::toStadiumResponse);
    }

}
