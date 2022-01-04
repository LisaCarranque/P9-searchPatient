package searchPatient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import searchPatient.model.Patient;
import searchPatient.repository.PatientRepository;

import java.util.List;

@Slf4j
@Service
public class PatientService implements IPatientService {

    boolean testMode = true;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Patient getPatientInformation(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname) {
        return patientRepository.findByfirstnameAndLastname(firstname, lastname);
    }

    @Override
    public Patient getPatientById(Integer id) {
        return patientRepository.getOne(id);
    }

    @Override
    public Patient addPatientInformation(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void removePatientInformation(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public Patient updatePatientInformation(Patient patient) {
        return patientRepository.save(patient);
    }

}
