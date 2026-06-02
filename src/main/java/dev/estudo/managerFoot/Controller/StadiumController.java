package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.request.StadiumRequest;
import dev.estudo.managerFoot.Controller.response.StadiumResponse;
import dev.estudo.managerFoot.Mapper.StadiumMapper;
import dev.estudo.managerFoot.Service.StadiumService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final StadiumService stadiumService;
    private final StadiumMapper stadiumMapper;
    public StadiumController(StadiumService stadiumService, StadiumMapper stadiumMapper) {
        this.stadiumService = stadiumService;
        this.stadiumMapper = stadiumMapper;
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:read','SCOPE_admin:all')")
    @GetMapping("/readAll")
    @ResponseStatus(HttpStatus.OK)
    public Page<StadiumResponse> listStadiums(Pageable pageable){
        return stadiumService.getAllStadium(pageable);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:read','SCOPE_admin:all')")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StadiumResponse findById(@PathVariable Long id){
        return stadiumMapper.toStadiumResponse(stadiumService.findById(id));
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_stadium:write','SCOPE_admin:all')")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse creat(@Valid @RequestBody StadiumRequest stadiumRequest){
        return  stadiumService.creat(stadiumRequest);
    }

}
