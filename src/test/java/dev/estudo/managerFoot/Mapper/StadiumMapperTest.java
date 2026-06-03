package dev.estudo.managerFoot.Mapper;

import dev.estudo.managerFoot.Controller.request.StadiumRequest;
import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Entity.Stadium;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class StadiumMapperTest {

    private final StadiumMapper stadiumMapper = Mappers.getMapper(StadiumMapper.class);

    @Test
    void toStadiumResponse() {
        //ARANGE
        Stadium stadium = Stadium.builder()
                                .id(1L)
                                .name("Test name")
                                .city("Teste city")
                                .urlImg("Teste URL")
                                .capacity(99999)
                                .build();

        //ACTION
        StadiumResponse response = stadiumMapper.toStadiumResponse(stadium);

        //ASSERTIONS
        assertEquals(stadium.getId(),response.getId());
        assertEquals(stadium.getName(), response.getName());
        assertEquals(stadium.getCity(), response.getCity());
        assertEquals(stadium.getUrlImg(), response.getUrlImg());
        assertEquals(stadium.getCapacity(),response.getCapacity());
    }

    @Test
    void toStadium() {
        //ARANGE
        StadiumRequest request = StadiumRequest.builder()
                .name("Test name")
                .city("Teste city")
                .urlImg("Teste URL")
                .capacity(99999)
                .build();

        //ACTION
        Stadium stadium = stadiumMapper.toStadium(request);

        //ASSERTIONS
        assertEquals(request.getName(), stadium.getName());
        assertEquals(request.getCity(), stadium.getCity());
        assertEquals(request.getUrlImg(), stadium.getUrlImg());
        assertEquals(request.getCapacity(),stadium.getCapacity());

    }

}