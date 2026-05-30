package dev.estudo.managerFoot.Mapper;

import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Entity.Club;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClubMapper {

    ClubResponse clubResponse(Club club);

    Club toClub(ClubResponse clubResponse);

}
