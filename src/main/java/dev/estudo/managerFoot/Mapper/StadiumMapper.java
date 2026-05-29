package dev.estudo.managerFoot.Mapper;


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

}
