package searchPatient.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import searchPatient.model.Patient;
import searchPatient.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PatientService implements IPatientService {

    boolean testMode = true;

    @Autowired
    PatientRepository patientRepository;


    /**
     * This method is responsible for getting all patient
     * @return the list of all patients
     */
    @Override
    public List<Patient> findAll() {
        log.info("searchPatient service : listing all patients");
        return patientRepository.findAll();
    }

    /**
     * This method is responsible getting a patient by id
     * @param id the id of the targeted patient
     * @return the targeted patient
     */
    @Override
    public Patient getPatientById(Integer id) {
        log.info("searchPatient service : get patient by id: " + id);
        return patientRepository.findById(id).orElse(null);
    }

    /**
     * This method is responsible for adding a patient
     * @param patient the patient to be added
     * @return the added patient
     */
    @Override
    public Patient addPatientInformation(Patient patient) {
        log.info("searchPatient service : adding patient with uuid:" + patient.getUuid());
        return patientRepository.save(patient);
    }

    /**
     * This method is responsible for removing patient information
     * @param patient the patient to be removed
     */
    @Override
    public void removePatientInformation(Patient patient) {
        log.info("searchPatient service : removing patient with uuid:" + patient.getUuid());
        patientRepository.delete(patient);
    }

    /**
     * This method is responsible for updating patient information
     * @param patient the patient to update
     * @return the updated patient
     */
    @Override
    public Patient updatePatientInformation(Patient patient) {
        log.info("searchPatient service : updating patient with uuid:" + patient.getUuid());
        return patientRepository.save(patient);
    }

    /**
     * This method is responsible for getting patient information by lastname
     * @param lastname the lastname of the targeted patient
     * @return the list of patients with this lastname
     */
    @Override
    public List<Patient> getPatientByLastname(String lastname) {
        log.info("searchPatient service : getting patient by lastname:" + lastname);
        return patientRepository.findByLastname(lastname);
    }

    /**
     * This method is responsible for getting all distinct lastname of patients
     * @return the list of all distinct lastname of patients
     */
    @Override
    public List<String> findAllDistinctLastnames() {
        log.info("searchPatient service : listing all patients");
        List<Patient> patients = patientRepository.findAll();
        List<String> lastnames = new ArrayList<>();
        patients.stream()
                .filter(p -> !lastnames.contains(p.getLastname()))
                .forEach(p -> lastnames.add(p.getLastname()));
        return lastnames.isEmpty() ? null : lastnames;
    }

}
