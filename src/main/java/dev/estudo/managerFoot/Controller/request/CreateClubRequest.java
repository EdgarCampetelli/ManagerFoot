package dev.estudo.managerFoot.Controller.request;

import dev.estudo.managerFoot.Entity.Stadium;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClubRequest {
    @NotBlank
    private String name;
    @NotNull
    private LocalDate founded;
    private Long stadiumId;
}
