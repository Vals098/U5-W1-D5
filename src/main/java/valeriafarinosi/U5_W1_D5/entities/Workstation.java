package valeriafarinosi.U5_W1_D5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import valeriafarinosi.U5_W1_D5.enums.WS_TYPE;
import valeriafarinosi.U5_W1_D5.exceptions.InvalidNumberException;
import valeriafarinosi.U5_W1_D5.exceptions.NotNullableException;

import java.util.UUID;

@Entity
@Table(name = "workstations")
@NoArgsConstructor
@Getter
@ToString
public class Workstation {

    @Id
    @GeneratedValue
    private UUID workstationID;

    @Column(name = "workstation_code", nullable = false, unique = true)
    private String WSCode;

    @Column(name = "workspace_description")
    private String WSDescription;

    @Column(name = "workspace_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private WS_TYPE WSType;

    @Column(name = "max_occupants_number", nullable = false)
    private int maxNOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    public Workstation(String WSCode, int maxNOccupants, WS_TYPE WSType, String WSDescription, Building building) {
        setBuilding(building);
        setMaxNOccupants(maxNOccupants);
        setWSCode(WSCode);
        setWSType(WSType);
        this.WSDescription = WSDescription;
    }

    public void setWSCode(String WSCode) {
        if (WSCode == null || WSCode.isBlank()) {
            throw new NotNullableException("Add a workstation code.");
        }
        this.WSCode = WSCode;
    }

    public void setWSType(WS_TYPE WSType) {
        if (WSType == null) {
            throw new NotNullableException("Add a workstation type.");
        }
        this.WSType = WSType;
    }

    public void setMaxNOccupants(int maxNOccupants) {
        if (maxNOccupants <= 0) {
            throw new InvalidNumberException("The number of occupants must be higher than 0.");
        }
        this.maxNOccupants = maxNOccupants;
    }

    public void setBuilding(Building building) {
        if (building == null) {
            throw new NotNullableException("Add a building to the workstation.");
        }
        this.building = building;
    }
}
