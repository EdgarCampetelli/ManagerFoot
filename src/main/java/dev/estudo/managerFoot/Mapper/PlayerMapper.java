package dev.estudo.managerFoot.Mapper;

import dev.estudo.managerFoot.Controller.request.PlayerRequest;
import dev.estudo.managerFoot.Controller.response.PlayerResponse;
import dev.estudo.managerFoot.Controller.response.PlayesDetailResponse;
import dev.estudo.managerFoot.Entity.Player;
import dev.estudo.managerFoot.Entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "position", source = "position", qualifiedByName = "enumToString")
    PlayerResponse toResponse(Player player);

    @Mapping(target = "position", source = "position", qualifiedByName = "enumToString")
    PlayesDetailResponse toDetailResponse(Player player);

    @Mapping(target = "club.id", source = "clubId")
    Player toPlayer(PlayerRequest request);

    @Named("enumToString")
    default String mapEnumPosition(Position position){
        return position != null ? position.getLabel(): null;
    }

}
