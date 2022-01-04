package searchPatient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import searchPatient.model.Patient;
import searchPatient.service.IPatientService;

import java.util.List;

@Slf4j
@RestController
public class PatientController {

    @Autowired
    IPatientService patientService;

    @RequestMapping("/patient/list")
    public List<Patient> home() {
        return patientService.findAll();
    }

    @RequestMapping("/patient/add")
    public Patient addPatientInformation(@RequestBody Patient patient) {
        return patientService.addPatientInformation(patient);
    }

    @RequestMapping("/patient/update/{id}")
    public Patient updatePatientInformation(@PathVariable String id) {
        return patientService.getPatientById(Integer.valueOf(id));
    }

    @RequestMapping("/patient/update")
    public Patient validateUpdate(@RequestBody Patient patient) {
        return patientService.updatePatientInformation(patient);
    }


}
