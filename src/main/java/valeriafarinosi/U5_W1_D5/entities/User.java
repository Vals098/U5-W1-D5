package valeriafarinosi.U5_W1_D5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import valeriafarinosi.U5_W1_D5.exceptions.NotNullableException;

import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@ToString
public class User {

    @Id
    @GeneratedValue
    private UUID userID;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public User(String email, String name, String surname, String username) {
        setEmail(email);
        setName(name);
        setSurname(surname);
        setUsername(username);
    }

    public void setUsername(String username) {
        if (username == null || username.isBlank()) {
            throw new NotNullableException("A username must be added.");
        }
        this.username = username;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NotNullableException("A name must be added.");
        }
        this.name = name;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isBlank()) {
            throw new NotNullableException("A surname must be added.");
        }
        this.surname = surname;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new NotNullableException("An email address must be added.");
        }
        this.email = email;
    }
}
