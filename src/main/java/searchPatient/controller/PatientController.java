package searchPatient.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import searchPatient.exception.PatientNotFoundException;
import searchPatient.model.Patient;
import searchPatient.service.IPatientService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * This controller is responsible for managing patient data
 */
@Slf4j
@RestController
@Api("Controller for searchPatient microservice")
public class PatientController {

    @Autowired
    IPatientService patientService;

    /**
     * This method is responsible for getting all patients
     * @return the list of all patients
     */
    @GetMapping("/patient/list")
    public List<Patient> home() {
        log.info("searchPatient controller : listing all patients");
        List<Patient> patients = patientService.findAll();
        return patients;
    }

    /**
     * This method is responsible for adding a patient
     * @param patient the patient to add
     * @return the added patient
     */
    @PostMapping("/patient/add")
    public Patient addPatientInformation(@RequestBody @Valid Patient patient) {
        if (patient.getUuid() == null) {
            patient.setUuid(UUID.randomUUID());
        }
        log.info("searchPatient controller : adding new patient with uuid: " + patient.getUuid());
        return patientService.addPatientInformation(patient);
    }

    /**
     * This method is responsible for getting patient information for further update
     * @param id the id of the targeted inforamtion
     * @return the patient to update
     */
    @GetMapping("/patient/update/{id}")
    public Patient updatePatientInformation(@PathVariable String id) {
        log.info("searchPatient controller : finding patient with id: " + id);
        return patientService.getPatientById(Integer.valueOf(id));
    }

    /**
     * This method is responsible for updating a patient
     * @param patient the patient to update
     * @return the updated patient
     */
    @PostMapping("/patient/update")
    public Patient validateUpdate(@RequestBody @Valid Patient patient) {
        log.info("searchPatient controller : updating patient with uuid: " + patient.getUuid()
                + "and id:" + patient.getId());
        return patientService.updatePatientInformation(patient);
    }

    /**
     * This method is responsible for get a patient by id
     * @param id the id of the targeted patient
     * @return the targeted patient
     */
    @GetMapping("/patient/get/{id}")
    public Patient getPatientById(@PathVariable String id) {
        log.info("searchPatient controller : getting patient with id: " + id);
        Patient patient = patientService.getPatientById(Integer.valueOf(id));
        if (patient == null) throw new PatientNotFoundException("No patient found in database for id: " + id);
        return patient;
    }

    /**
     * This method is responsible for get all patients
     * @return the list of all patients
     */
    @GetMapping("/patient/getAll")
    public List<Patient> getAll() {
        log.info("searchPatient controller : finding all patients");
        List<Patient> patients = patientService.findAll();
        return patients;
    }

    /**
     * This method is responsible for get all distinct lastname of patients
     * @return the list of all distinct lastname of patients
     */
    @GetMapping("/patient/getAllDistinctLastnames")
    public List<String> getAllDistinct() {
        log.info("searchPatient controller : finding all distinct lastname of patients");
        List<String> lastnames = patientService.findAllDistinctLastnames();
        return lastnames;
    }

    /**
     * This method is responsible for getting a patient by lastname
     * @param lastname the lastname of the targeted patient
     * @return the targeted patient
     */
    @GetMapping("/patient/getByLastname/{lastname}")
    public List<Patient> getPatientByLastname(@PathVariable String lastname) {
        log.info("searchPatient controller : getting patient with lastname: " + lastname);
        List<Patient> patients = patientService.getPatientByLastname(lastname);
        if (patients.isEmpty()) throw new PatientNotFoundException("No patient found in database for lastname: " + lastname);
        return patients;
    }


}
