package dev.estudo.managerFoot.Mapper;


import dev.estudo.managerFoot.Controller.request.StadiumRequest;
import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Entity.Stadium;

public class StadiumMapper {

    public static StadiumResponse toStadiumResponse(Stadium stadium){
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImg())
                .build();
    }

    public static Stadium toStadium (StadiumRequest stadiumRequest){
        return Stadium.builder()
                .name(stadiumRequest.getName())
                .city(stadiumRequest.getCity())
                .capacity(stadiumRequest.getCapacity())
                .urlImg(stadiumRequest.getUrlImg())
                .build();
    }

}
