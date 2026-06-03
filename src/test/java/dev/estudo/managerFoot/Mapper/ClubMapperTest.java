package dev.estudo.managerFoot.Mapper;

import dev.estudo.managerFoot.Controller.response.ClubResponse;
import dev.estudo.managerFoot.Entity.Club;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClubMapperTest {

    private final ClubMapper mapper = Mappers.getMapper(ClubMapper.class);

    @Test
    void clubResponse() {

        //ARANGE
        Club club = Club.builder()
                .id(1L)
                .name("Teste name")
                .founded(LocalDate.parse("2002-08-31"))
                .url_img("Teste URL")
                .build();

        //Action
        ClubResponse response = mapper.clubResponse(club);

        assertEquals(club.getId(), response.getId());
        assertEquals(club.getName(),response.getName());
        assertEquals(club.getFounded(),response.getFounded());
        assertEquals(club.getUrl_img(),response.getUrl_img());

    }

    @Test
    void toClubDetailResponse() {
    }

    @Test
    void toClub() {
    }
}