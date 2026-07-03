package valeriafarinosi.U5_W1_D5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import valeriafarinosi.U5_W1_D5.entities.Workstation;

import java.util.UUID;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, UUID> {
    boolean existsByWSCode(String wsCode);
}
