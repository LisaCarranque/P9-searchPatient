package searchPatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import searchPatient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

    Patient findByfirstnameAndLastname(String firstname, String lastname);
}
