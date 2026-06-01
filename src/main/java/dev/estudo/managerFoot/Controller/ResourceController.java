package dev.estudo.managerFoot.Controller;

import dev.estudo.managerFoot.Controller.response.PositionsResponse;
import dev.estudo.managerFoot.Entity.Position;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @GetMapping("/positions")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionsResponse> getPositions(){
        return Arrays.stream(Position.values()).map(i-> new PositionsResponse(i.name(), i.getLabel())).toList();
    }

}
