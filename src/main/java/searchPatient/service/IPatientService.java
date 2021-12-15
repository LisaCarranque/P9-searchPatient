package searchPatient.service;

import org.springframework.web.bind.annotation.RequestParam;
import searchPatient.model.Patient;

import java.util.List;

public interface IPatientService {

    List<Patient> findAll();

    public Patient getPatientInformation(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname);

    Patient getPatientById(@RequestParam Integer id);

    Patient addPatientInformation(Patient patient);

    void removePatientInformation(Patient patient);

    Patient updatePatientInformation(Patient patient);
}
