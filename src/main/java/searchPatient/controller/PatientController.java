package searchPatient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import searchPatient.model.Patient;
import searchPatient.service.IPatientService;

import javax.validation.Valid;

@Slf4j
@Controller
public class PatientController {

    @Autowired
    IPatientService patientService;


    /**
     * This method is responsible for getting the welcome view
     *
     * @param model
     * @return the welcome view
     */
    @RequestMapping("/index")
    public String index(Model model) {
        log.info("Displaying welcome view");
        return "index";
    }

    /**
     * This method is responsible for getting a list of all patients existing in database
     *
     * @param model
     * @return the list of all patients in database
     */
    @RequestMapping("/patient/list")
    public String home(Model model) {
        log.info("PatientController : finding all patients");
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("patient", Patient.builder().build());
        return "list";
    }

    /**
     * This method is responsible for adding patient data
     *
     * @param model
     * @return the list of all patients in database with the new patient data
     */
    @RequestMapping("/patient/add")
    public String addPatientInformation(Model model, @Valid Patient patient) {
        log.info("Patient controller : adding patient data");
        System.out.println(patient.getAddress());
        System.out.println(patient.getBirthdate());
        System.out.println(patient.getGenre());
        System.out.println(patient.getFirstname());
        System.out.println(patient.getLastname());
        System.out.println(patient.getId());
        System.out.println(patient.getPhone());
        System.out.println(patient.getUuid());
        patientService.addPatientInformation(patient);
        log.info("Patient controller : patient data added");
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("patient", Patient.builder().build());
        return "list";
    }

    /**
     * This method is responsible for updating patient data
     *
     * @param model
     * @return the list of all patients in database with the updated patient data
     */
    @GetMapping("/patient/update/{id}")
    public String updatePatientInformation(Model model, @PathVariable Integer id) {
        log.info("PatientController : getting patient information to update");
        model.addAttribute("patient", patientService.getPatientById(id));
        return "edit";
    }

    /**
     * This method is responsible for updating patient data
     *
     * @param model
     * @return the list of all patients in database with the updated patient data
     */
    @PostMapping("/patient/update")
    public String validateUpdate(Model model, @ModelAttribute @Valid Patient patient) {
        log.info("PatientController :  updating patient information");
        patientService.updatePatientInformation(patient);
        log.info("displaying patient liss");
        model.addAttribute("patients", patientService.findAll());
        model.addAttribute("patient", Patient.builder().build());
        return "list";
    }


}
