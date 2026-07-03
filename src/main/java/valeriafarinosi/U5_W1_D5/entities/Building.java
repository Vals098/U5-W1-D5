package valeriafarinosi.U5_W1_D5.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import valeriafarinosi.U5_W1_D5.exceptions.NotNullableException;

import java.util.UUID;

@Entity
@Table(name = "buildings")
@NoArgsConstructor
@Getter
@ToString
public class Building {

    @Id
    @GeneratedValue
    private UUID buildingID;

    @Column(name = "building_name", nullable = false)
    private String name;

    @Column(name = "building_address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    public Building(String name, String address, String city) {
        setAddress(address);
        setBuildingName(name);
        setCity(city);
    }

    public void setAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new NotNullableException("You must add a name for your building.");
        }
        this.address = address;
    }

    public void setBuildingName(String name) {
        if (name == null || name.isBlank()) {
            throw new NotNullableException("You must add a name for your building.");
        }
        this.name = name;
    }

    public void setCity(String city) {
        if (city == null || city.isBlank()) {
            throw new NotNullableException("You must add a city for your building.");
        }
        this.city = city;
    }
}
