package dev.estudo.managerFoot.Service;

import dev.estudo.managerFoot.Controller.exception.ResourceNotFoundException;
import dev.estudo.managerFoot.Controller.request.StadiumRequest;
import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Entity.Stadium;
import dev.estudo.managerFoot.Mapper.StadiumMapper;
import dev.estudo.managerFoot.Repository.StadiumRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public StadiumService(StadiumRepository stadiumRepository, StadiumMapper stadiumMapper) {
        this.stadiumRepository = stadiumRepository;
        this.stadiumMapper = stadiumMapper;
    }

    /*==============================================================================*/

    public Page<StadiumResponse> getAllStadium(Pageable pageable){
        return stadiumRepository.findAll(pageable)
                .map(stadiumMapper::toStadiumResponse);
    }

    public Stadium findById(Long id){
        return stadiumRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Stadium not found for id: "+id));
    }

    public StadiumResponse creat(StadiumRequest stadiumRequest){
        Stadium saveStadium = stadiumRepository.save(stadiumMapper.toStadium(stadiumRequest));
        return stadiumMapper.toStadiumResponse(saveStadium);
    }

}
