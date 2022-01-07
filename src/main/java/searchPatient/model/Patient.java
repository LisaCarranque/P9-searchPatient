package searchPatient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

/**
 * The model for patients gathering their personal information
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Generated
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Column(name = "firstname")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String firstname;
    @Column(name = "lastname")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String lastname;
    @Column(name = "gender")
    @NonNull
    Gender gender;
    @Column(name = "address")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String address;
    @Column(name = "phone")
    @NotEmpty
    @NonNull
    @Size(min=1, max=40)
    String phone;
    @Column(name = "birthdate")
    @NonNull
    LocalDate birthdate;
    @Column(name = "uuid")
    UUID uuid;

}
