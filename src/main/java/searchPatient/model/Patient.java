package searchPatient.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "firstname")
    String firstname;
    @Column(name = "lastname")
    String lastname;
    @Column(name = "genre")
    String genre;
    @Column(name = "address")
    String address;
    @Column(name = "phone")
    String phone;
    @Column(name = "birthdate")
    LocalDate birthdate;
    @Column(name = "uuid")
    UUID uuid;

}
