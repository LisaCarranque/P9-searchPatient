package searchPatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchPatient.model.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByLastname(String lastname);

}
