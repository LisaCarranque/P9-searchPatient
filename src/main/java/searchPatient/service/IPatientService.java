package searchPatient.service;

import org.springframework.web.bind.annotation.RequestParam;
import searchPatient.model.Patient;

import java.util.List;

/**
 * This interface is responsible for managing patient information
 */
public interface IPatientService {


    /**
     * This method is responsible for getting all patient
     * @return the list of all patients
     */
    List<Patient> findAll();

    /**
     * This method is responsible getting a patient by id
     * @param id the id of the targeted patient
     * @return the targeted patient
     */
    Patient getPatientById(@RequestParam Integer id);

    /**
     * This method is responsible for adding a patient
     * @param patient the patient to be added
     * @return the added patient
     */
    Patient addPatientInformation(Patient patient);

    /**
     * This method is responsible for removing patient information
     * @param patient the patient to be removed
     */
    void removePatientInformation(Patient patient);

    /**
     * This method is responsible for updating patient information
     * @param patient the patient to update
     * @return the updated patient
     */
    Patient updatePatientInformation(Patient patient);

    /**
     * This method is responsible for getting patient information by lastname
     * @param lastname the lastname of the targeted patient
     * @return the list of patients with this lastname
     */
    List<Patient> getPatientByLastname(String lastname);

    /**
     * This method is responsible for getting all distinct lastname of patients
     * @return the list of all distinct lastname of patients
     */
    public List<String> findAllDistinctLastnames();
}
