package dev.estudo.managerFoot.Mapper;

import dev.estudo.managerFoot.Controller.request.CreateClubRequest;
import dev.estudo.managerFoot.Controller.response.ClubDetailResponse;
import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { StadiumMapper.class })
public interface ClubMapper {

    ClubResponse clubResponse(Club club);

    ClubDetailResponse toClubDetailResponse(Club club);

    @Mapping(target = "stadium.id", source = "stadiumId")
    Club toClub(CreateClubRequest request);
}
