package searchPatient.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import searchPatient.model.Gender;
import searchPatient.model.Patient;
import searchPatient.service.PatientService;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * This class is responsible for testing PatientController
 */
@ExtendWith(MockitoExtension.class)
public class PatientControllerTest {

    @InjectMocks
    PatientController patientController;

    @Mock
    PatientService patientService;

    @Mock
    Model model;

    @Test
    public void loadController() {
        assertNotNull(patientController);
    }


    @Test
    public void updatePatientInformationTest() {
        patientController.updatePatientInformation("1");
        verify(patientService).getPatientById(1);
    }

    @Test
    public void addPatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Patient patient = Patient.builder().id(1).firstname("John")
                .lastname("Smith").address("1st street").phone("0000000000").uuid(uuid).birthdate(LocalDate.now()).gender(Gender.M).build();
        patientController.addPatientInformation(patient);
        verify(patientService).addPatientInformation(patient);
    }

    @Test
    public void validatePatientInformationTest() {
        UUID uuid = UUID.randomUUID();
        Patient patient = Patient.builder().id(1).firstname("John")
                .lastname("Smith").address("1st street").phone("0000000000").uuid(uuid).birthdate(LocalDate.now()).gender(Gender.M).build();
        patientController.validateUpdate(patient);
        verify(patientService).updatePatientInformation(patient);
    }

    @Test
    public void getAllTest() {
        patientController.getAll();
        verify(patientService).findAll();
    }

    @Test
    public void getAllDistinctTest() {
        patientController.getAllDistinct();
        verify(patientService).findAllDistinctLastnames();
    }

    @Test
    public void getPatientByLastnameTest() {
        patientController.getPatientByLastname("lastname");
        verify(patientService).getPatientByLastname("lastname");
    }

    @Test
    public void getPatientByIdTest() {
        patientController.getPatientById("1");
        verify(patientService).getPatientById(1);
    }
}
