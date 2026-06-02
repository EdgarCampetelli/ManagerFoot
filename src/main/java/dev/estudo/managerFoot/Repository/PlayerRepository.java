package dev.estudo.managerFoot.Repository;

import dev.estudo.managerFoot.Entity.Player;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

    @EntityGraph(attributePaths = "club")
    List<Player> findByClubId (Long id);
}
