package valeriafarinosi.U5_W1_D5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import valeriafarinosi.U5_W1_D5.entities.Workstation;
import valeriafarinosi.U5_W1_D5.enums.WS_TYPE;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkstationRepository extends JpaRepository<Workstation, UUID> {
    boolean existsByWSCode(String wsCode);

    Optional<Workstation> findByWSCode(String WSCode);

    @Query("SELECT w FROM Workstation w WHERE w.WSType = :type AND w.building.city = :city")
    List<Workstation> findByWSTypeAndCity(@Param("type") WS_TYPE WSType, @Param("city") String city);

}
