package searchPatient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        log.info("find all patient");
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Integer id) {
        log.info("getting patient by id");
        return patientRepository.getOne(id);
    }

    @Override
    public Patient addPatientInformation(Patient patient) {
        log.info("saving patient");
        return patientRepository.save(patient);
    }

    @Override
    public void removePatientInformation(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public Patient updatePatientInformation(Patient patient) {
        log.info("updating patient");
        return patientRepository.save(patient);
    }

}
