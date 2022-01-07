package searchPatient.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import searchPatient.exception.PatientNotFoundException;
import searchPatient.model.Gender;
import searchPatient.model.Patient;
import searchPatient.service.PatientService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        when(patientService.getPatientByLastname("lastname")).thenReturn(Collections.singletonList(Patient
                .builder().firstname("firstname").lastname("lastname").phone("00000000").gender(Gender.F)
                .birthdate(LocalDate.now()).address("1st street").uuid(UUID.randomUUID()).id(1).build()));
        patientController.getPatientByLastname("lastname");
        verify(patientService).getPatientByLastname("lastname");
    }

    @Test
    public void getPatientByIdTest() {
        when(patientService.getPatientById(1)).thenReturn(Patient
                .builder().firstname("firstname").lastname("lastname").phone("00000000").gender(Gender.F)
                .birthdate(LocalDate.now()).address("1st street").uuid(UUID.randomUUID()).id(1).build());
        patientController.getPatientById("1");
        verify(patientService).getPatientById(1);
    }

    @Test
    public void getPatientByLastnameThrowsExceptionTest() {
        assertThrows(PatientNotFoundException.class , () -> patientController.getPatientByLastname("lastname"));
    }

    @Test
    public void getPatientByIdThrowsExceptionTest() {
        assertThrows(PatientNotFoundException.class , () -> patientController.getPatientById("1"));
    }
}
