package dev.estudo.managerFoot.Mapper;


import dev.estudo.managerFoot.Controller.request.StadiumRequest;
import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Entity.Stadium;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StadiumMapper {

    StadiumResponse toStadiumResponse(Stadium stadium);

    Stadium toStadium (StadiumRequest stadiumRequest);

}
